package com.rf.javamvvmdemo;

import android.app.Application;

import com.rf.javamvvmdemo.sdkInit.JavaMVVMDemoSDK;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JavaMVVMDemoSDK.initialize(this);
    }
}
