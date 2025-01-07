package com.rf.javamvvmdemo.ui.main.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rf.javamvvmdemo.R;
import com.rf.javamvvmdemo.databinding.ActivityArticleBinding;
import com.rf.javamvvmdemo.roomDB.model.ArticleModel;
import com.rf.javamvvmdemo.sdkInit.JavaMVVMDemoSDK;
import com.rf.javamvvmdemo.ui.base.BaseActivity;
import com.rf.javamvvmdemo.ui.base.BaseActivityModule;
import com.rf.javamvvmdemo.ui.base.BaseViewModelFactory;
import com.rf.javamvvmdemo.ui.main.adapter.ArticleListAdapter;
import com.rf.javamvvmdemo.ui.main.di.ArticleActivityModule;
import com.rf.javamvvmdemo.ui.main.di.DaggerArticleActivityComponent;
import com.rf.javamvvmdemo.ui.main.viewmodel.ArticleViewModel;
import com.rf.javamvvmdemo.utils.NetworkHelper;
import com.rf.javamvvmdemo.utils.SharedPreference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class ArticleActivity extends BaseActivity<ActivityArticleBinding> {

    @Inject
    NetworkHelper networkHelper;

    @Inject
    Dialog progressBar;

    @Inject
    SharedPreference sharedPreference;

    @Inject
    BaseViewModelFactory<ArticleViewModel> articleViewModelFactory;

    ArticleListAdapter articleListAdapter;
    ArrayList<ArticleModel> articleList = new ArrayList<>();

    private ArticleViewModel viewModel;

    public ArticleActivity() {
        super(R.layout.activity_article);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        initializationDagger();
        initializationView();
    }

    private void initializationView() {
        setAdapter();
        getArticleList();
        viewDataBinding.searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArticleList();
            }
        });
    }

    private void initializationDagger() {
        DaggerArticleActivityComponent.builder()
                .appComponent(JavaMVVMDemoSDK.getAppComponent())
                .articleActivityModule(new ArticleActivityModule())
                .baseActivityModule(new BaseActivityModule(this))
                .build()
                .inject(this);

        viewModel = new ViewModelProvider(this, articleViewModelFactory).get(ArticleViewModel.class);
    }

    private void setAdapter() {
        articleListAdapter = new ArticleListAdapter(articleList, article -> {
            // Handle article click event
        });
        viewDataBinding.articleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewDataBinding.articleRecyclerView.setAdapter(articleListAdapter);
    }

    private void getArticleList() {
        if (networkHelper.isNetworkConnected()) {
            viewModel.getArticleList();
            viewModel.articleListLiveData.observe(this, response -> {
                if (response != null) {
                    switch (response.getStatus()) {
                        case SUCCESS:
                           // progressBar.dismiss();
                            if (response.getData() != null) {
                                List<ArticleModel> articles = response.getData();
                                articleList.addAll(articles);
                            }
                            articleListAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            //progressBar.dismiss();
                            showMessage(response.getMessage());
                            break;
                        case LOADING:
                            //progressBar.show();
                            break;
                    }
                }
            });
        }else{
            List<ArticleModel> articles = viewModel.getLocalArticleList();
            articleList.addAll(articles);
        }
    }

}
