package com.rf.javamvvmdemo.data.remote;

import com.rf.javamvvmdemo.data.model.response.ArticleListResponse;
import com.rf.javamvvmdemo.ui.base.BaseResponseModel2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface JavaMVVMDemoServices {

    @Headers("Content-Type:application/json")
    @GET("/v1/7bc9509c-9c5e-4db7-9304-cfb40d27b672")
    Call<BaseResponseModel2<ArticleListResponse>> getArticleList(@Header("Authorization") String authHeader);

}
