package com.ixuea.courses.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        TextView mtv1 = findViewById(R.id.tv_2);
        mtv1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
        mtv1.getPaint().setAntiAlias(true);//去除锯齿

        TextView mtv2 = findViewById(R.id.tv_3);
        mtv2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线

        TextView mtv3 = findViewById(R.id.tv_4);
        mtv3.setText(Html.fromHtml("<u>huangzexiao</u>"));//此方法已过期

        TextView mtv4 = findViewById(R.id.tv_5);
        mtv4.setSelected(true);//将跑马灯选中，才能让它动起来

        Button bt = findViewById(R.id.bt_close);
        bt.setOnClickListener(this);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(TextViewActivity.this, MainActivity.class);
//                startActivity(intent);
//                Toast.makeText(TextViewActivity.this, "转跳到MainActivity", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
    public void onClick(View view){ finish();}
}
