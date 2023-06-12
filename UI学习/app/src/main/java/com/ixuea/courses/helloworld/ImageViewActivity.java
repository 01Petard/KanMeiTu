package com.ixuea.courses.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {


    private ImageView mIv4;
    private ImageView mIv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv4 = findViewById(R.id.iv_4);
        mIv5 = findViewById(R.id.iv_5);
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1570958534771&di=9422da797bb92d9c9e3ffba4b328fe7b&imgtype=0&src=http%3A%2F%2Fimg011.hc360.cn%2Fhb%2FMTQ1NzgxNzQ0OTMzOTI4NzU5ODM0NQ%3D%3D.jpg").into(mIv4);
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571665793085&di=c113022fc3da01839f6de2a260f260a1&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F8f016b1f97298b7ea8dc87b7c1fa5d1405de5c591422d-XudrBf_fw658").into(mIv5);
    }
}
