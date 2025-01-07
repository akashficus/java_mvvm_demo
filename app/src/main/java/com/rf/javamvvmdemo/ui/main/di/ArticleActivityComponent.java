package com.rf.javamvvmdemo.ui.main.di;

import com.rf.javamvvmdemo.sdkInit.di.AppComponent;
import com.rf.javamvvmdemo.ui.base.BaseActivityModule;
import com.rf.javamvvmdemo.ui.main.activity.ArticleActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {ArticleActivityModule.class, BaseActivityModule.class})
public interface ArticleActivityComponent {
    void inject(ArticleActivity articleActivity);
}

