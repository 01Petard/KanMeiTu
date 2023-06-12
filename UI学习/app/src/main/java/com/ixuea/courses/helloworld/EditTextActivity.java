package com.ixuea.courses.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        EditText edt = findViewById(R.id.et_1);
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditTextActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            }
        });
        //监听用户名的输入
        EditText etUsername = findViewById(R.id.et_1);
        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("edittext",s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //监听密码的输入
        EditText etPassword = findViewById(R.id.et_2);
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("edittext",s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
