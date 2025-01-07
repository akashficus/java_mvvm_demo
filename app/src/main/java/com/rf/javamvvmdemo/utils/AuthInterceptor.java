package com.rf.javamvvmdemo.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private final SharedPreference sharedPreference;

    public AuthInterceptor(SharedPreference sharedPreference) {
        this.sharedPreference = sharedPreference;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        Request.Builder requestBuilder = originalRequest.newBuilder()
                .header("Content-Type", "application/json")
                //.header("Authorization", "Bearer " + sharedPreference.getAuthToken())
               // .header("App-Version", String.valueOf(BuildConfig.VERSION_CODE))
                .header("Connection", "close");

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}