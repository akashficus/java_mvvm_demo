package com.rf.javamvvmdemo.data.repository;

import android.content.Context;

import com.rf.javamvvmdemo.data.model.response.ArticleListResponse;
import com.rf.javamvvmdemo.data.remote.JavaMVVMDemoServices;
import com.rf.javamvvmdemo.roomDB.JavaMVVMDemoDB;
import com.rf.javamvvmdemo.roomDB.model.ArticleModel;
import com.rf.javamvvmdemo.ui.base.BaseRepository;
import com.rf.javamvvmdemo.utils.SharedPreference;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository extends BaseRepository {

    private final JavaMVVMDemoServices apiServices;
    private final Context context;
    private final SharedPreference sharedPreference;
    private final JavaMVVMDemoDB javaMVVMDemoDB;

    /**
     * Constructor to initialize dependencies.
     *
     * @param apiServices       Instance of JavaMVVMDemoServices for API calls
     * @param context           Application or Activity context
     * @param sharedPreference  Instance of SharedPreference for managing preferences
     * @param javaMVVMDemoDB    Instance of JavaMVVMDemoDB for database operations
     */
    public ArticleRepository(
            JavaMVVMDemoServices apiServices,
            Context context,
            SharedPreference sharedPreference,
            JavaMVVMDemoDB javaMVVMDemoDB
    ) {
        this.apiServices = apiServices;
        this.context = context;
        this.sharedPreference = sharedPreference;
        this.javaMVVMDemoDB = javaMVVMDemoDB;
    }

    public void getArticleList(
            OnSuccessCallback<List<ArticleListResponse>> success,
            OnErrorCallback fail,
            onMessageCallback message
    ) {
        String authHeader = "Bearer ";
        execute2(apiServices.getArticleList(authHeader), success, fail, context, message);
    }

    public List<ArticleModel> getLocalArticleList() {
        return javaMVVMDemoDB.fioDao().getLocalArticleList();
    }

    public void insertArticle(ArticleModel articleModel) {
        javaMVVMDemoDB.fioDao().insertArticle(articleModel);
    }
}
