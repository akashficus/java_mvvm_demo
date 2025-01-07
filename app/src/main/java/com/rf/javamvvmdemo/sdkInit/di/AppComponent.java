package com.rf.javamvvmdemo.sdkInit.di;

import android.content.Context;

import com.rf.javamvvmdemo.roomDB.JavaMVVMDemoDB;
import com.rf.javamvvmdemo.sdkInit.JavaMVVMDemoSDK;
import com.rf.javamvvmdemo.utils.NetworkHelper;
import com.rf.javamvvmdemo.utils.SharedPreference;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(JavaMVVMDemoSDK javaMVVMDemoSDK);

    SharedPreference getSharedPreference();

    Retrofit getRetrofit();

    NetworkHelper getNetwork();

    Context getContext();

    JavaMVVMDemoDB getJavaMVVMDemoBD();

}
