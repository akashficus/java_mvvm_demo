package com.rf.javamvvmdemo.sdkInit;

import android.app.Application;

import com.rf.javamvvmdemo.sdkInit.di.AppComponent;
import com.rf.javamvvmdemo.sdkInit.di.AppModule;
import com.rf.javamvvmdemo.sdkInit.di.DaggerAppComponent;
import com.rf.javamvvmdemo.ui.base.BaseSDK;

public class JavaMVVMDemoSDK extends BaseSDK {
    private static Application mApplication;
    private static AppComponent appComponent;

    private JavaMVVMDemoSDK() {
        // Private constructor to prevent instantiation
    }

    public static JavaMVVMDemoSDK initialize(Application application) {
        mApplication = application;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
        appComponent.inject(new JavaMVVMDemoSDK());
        return new JavaMVVMDemoSDK();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static Application getApplication() {
        return mApplication;
    }
}
