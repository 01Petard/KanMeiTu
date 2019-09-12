package com.ixuea.courses.kaimeitu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ixuea.courses.kaimeitu.Adapter.ImageAdapter;
import com.ixuea.courses.kaimeitu.activity.BaseActivity;
import com.ixuea.courses.kaimeitu.activity.LoginActivity;
import com.ixuea.courses.kaimeitu.domain.Image;
import com.ixuea.courses.kaimeitu.util.SharedPreferencesUtil;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        //实现2例，我们这里实现的是每个图片的宽高都一样
        //最好的效果其实是根据图片高度和宽度来缩放
        //因为每一张图片大小都不一样
        //但这样实现涉及到的知识点很多

        //这里使用了GridLayoutManage
        //它会显示类似九宫格布局效果

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(gridLayoutManager);

        //设置数据
        ArrayList<Image> datas= new ArrayList<>();
        for (int i=1;i<21;i++){
            //图片来自百度图片
            //datas.add(new Image(String.format("http://dev-courses-quick.oss-c-beijing.aliyuncs.com/%d.jpg",i)));
            datas.add(new Image(String.format("http://dev-courses-quick.oss-cn-beijing.aliyuncs.com/%d.jpg",i)));
        }
        ImageAdapter adapter = new ImageAdapter(this);
        rv.setAdapter(adapter);
        adapter.setData(datas);
    }

    /**
     * 退出按钮
     * @param view
     */
    public void onLogoutClick(View view) {
        sp.setLogin(false);

        //退出后转跳登录界面
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
