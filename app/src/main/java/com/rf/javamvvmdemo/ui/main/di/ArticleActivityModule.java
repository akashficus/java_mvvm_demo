package com.rf.javamvvmdemo.ui.main.di;

import android.content.Context;

import com.rf.javamvvmdemo.data.remote.JavaMVVMDemoServices;
import com.rf.javamvvmdemo.data.repository.ArticleRepository;
import com.rf.javamvvmdemo.roomDB.JavaMVVMDemoDB;
import com.rf.javamvvmdemo.ui.base.BaseViewModelFactory;
import com.rf.javamvvmdemo.ui.main.viewmodel.ArticleViewModel;
import com.rf.javamvvmdemo.utils.SharedPreference;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ArticleActivityModule {

    @Provides
    @ActivityScope
    public JavaMVVMDemoServices provideApiServices(Retrofit retrofit) {
        return retrofit.create(JavaMVVMDemoServices.class);
    }

    @Provides
    @ActivityScope
    public ArticleRepository provideArticleRepository(
            JavaMVVMDemoServices apiServices,
            Context context,
            SharedPreference sharedPreference,
            JavaMVVMDemoDB javaMVVMDemoDB) {
        return new ArticleRepository(apiServices, context, sharedPreference, javaMVVMDemoDB);
    }

    @ActivityScope
    @Provides
    public BaseViewModelFactory<ArticleViewModel> provideViewModelFactory(ArticleRepository signInRepository) {
        return new BaseViewModelFactory<>(() -> new ArticleViewModel(signInRepository));
    }
}
