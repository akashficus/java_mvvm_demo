package com.rf.javamvvmdemo.ui.base;

import com.rf.javamvvmdemo.utils.SharedPreference;

import javax.inject.Inject;

public abstract class BaseSDK {
    @Inject
    SharedPreference sharedPreference;
}
