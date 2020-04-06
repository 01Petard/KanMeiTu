package com.ixuea.courses.kaimeitu.api;


import android.renderscript.ScriptIntrinsicBLAS;

import com.ixuea.courses.kaimeitu.domain.Image;
import com.ixuea.courses.kaimeitu.domain.response.ListResponse;
import com.ixuea.courses.kaimeitu.util.Constants;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api instance;
    private static Service service;

    Api() {
        //OkHttp有很多配置
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //这里是创建Retrofit
        //同样他也有很多配置
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(Constants.ENDPOINT)//这就是配置API地址
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Service.class);
    }

    /**
     * 返回当前对象地唯一实测
     *
     * 单例设计模式
     *
     * @return
     */
    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }
        return instance;
    }

    public Observable<ListResponse<Image>> images() {
        //调用了service里面的方法
        //service是一个接口
        //调用接口之所以还能返回数据
        //是rerofit框架内容代理的该方法的调用
        return service.images();
    }

}
