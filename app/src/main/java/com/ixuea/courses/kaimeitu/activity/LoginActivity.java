package com.ixuea.courses.kaimeitu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ixuea.courses.kaimeitu.MainActivity;
import com.ixuea.courses.kaimeitu.R;
import com.ixuea.courses.kaimeitu.util.Constants;
import com.ixuea.courses.kaimeitu.util.RegexUtil;
import com.ixuea.courses.kaimeitu.util.SharedPreferencesUtil;

import java.util.concurrent.locks.Condition;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_username;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        Button bt_login = findViewById(R.id.bt_login);

        bt_login.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                login();
                break;
        }
    }

    public void login() {
        //获取用户名输入的邮箱、密码，做校验
        String username = et_username.getText().toString().trim();
        //判断是否输入了邮箱
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, R.string.email_hint, Toast.LENGTH_SHORT).show();
            return;
        }
        //通过正则表达式判断邮箱格式是否正确
        if (!RegexUtil.isEmail(username)) {
            Toast.makeText(this, R.string.email_error, Toast.LENGTH_SHORT).show();
            return;
        }

        String password = et_password.getText().toString().trim();
        //判断是否输入了密码
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, R.string.password_hint, Toast.LENGTH_SHORT).show();
            return;
        }
        //通过正则表达式判断密码格式是否正确
        if (password.length() < 6 || password.length() > 15) {
            Toast.makeText(this, R.string.password_length_error, Toast.LENGTH_SHORT).show();
            return;
        }

        //TODO 真实项目中会调用服务端的登录接口
        //这里为简单起见，将用户名和密码写到本地
        if (Constants.USERNAME.equals(username) && Constants.PASSWORD.equals(password)) {
            //登录完成后保存一个标志，下次就不用登录了
            sp.setLogin(true);//因为封装了BaseActivity，所以不用再创建sp的实例变量了
            //登录成功，进入首页
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            //关闭当前界面
            finish();
        }else{
            //登录失败，进行提示
            Toast.makeText(this, R.string.username_or_password_error, Toast.LENGTH_SHORT).show();
        }
    }
}
