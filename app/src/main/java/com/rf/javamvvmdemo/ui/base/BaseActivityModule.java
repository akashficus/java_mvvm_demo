package com.rf.javamvvmdemo.ui.base;


import android.app.Dialog;
import android.content.Context;

import com.rf.javamvvmdemo.ui.main.di.ActivityScope;
import com.rf.javamvvmdemo.utils.Utility;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseActivityModule {

    private final Context context;

    public BaseActivityModule(Context context) {
        this.context = context;
    }

    /**
     * Provides a common progress bar dependency.
     */
    @Provides
    @ActivityScope
    public Dialog getProgressBar(Context context) {
        return Utility.showCommonProgressDialog(context);
    }
}