package com.ixuea.courses.kaimeitu.api;

import com.ixuea.courses.kaimeitu.domain.Image;
import com.ixuea.courses.kaimeitu.domain.response.ListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Service {
    /**
     * 获取图片列表
     * @return
     */
    @GET("v1/images")
    Observable<ListResponse<Image>> images();
}
