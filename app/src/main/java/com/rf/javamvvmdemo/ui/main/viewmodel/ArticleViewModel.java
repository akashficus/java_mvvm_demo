package com.rf.javamvvmdemo.ui.main.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.rf.javamvvmdemo.data.model.response.ArticleListResponse;
import com.rf.javamvvmdemo.data.repository.ArticleRepository;
import com.rf.javamvvmdemo.roomDB.model.ArticleModel;
import com.rf.javamvvmdemo.ui.base.BaseViewModel;
import com.rf.javamvvmdemo.utils.errorHandler.ResponseData;
import com.rf.javamvvmdemo.utils.errorHandler.ResponseDataOfArray;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;

public class ArticleViewModel extends BaseViewModel {
    private final ArticleRepository articleRepository;
    public final MutableLiveData<ResponseDataOfArray<ArticleModel>> articleListLiveData = new MutableLiveData<>();

    @Inject
    public ArticleViewModel(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void getArticleList() {
        articleListLiveData.setValue(ResponseDataOfArray.loading(null));
        articleRepository.getArticleList(success ->{
                    ArrayList<ArticleModel> arrayList = new ArrayList<>();
                    for (ArticleListResponse articleListResponse : success) {

                        ArticleModel articleModel = new ArticleModel(articleListResponse.getArticleId(),
                                articleListResponse.getTitle(),
                                articleListResponse.getDescription(),
                                articleListResponse.getDate(),
                                articleListResponse.getImageUrl());
                        articleRepository.insertArticle(articleModel);
                        arrayList.add(articleModel);
                    }
                    articleListLiveData.setValue(ResponseDataOfArray.success(arrayList));
                },
                error -> articleListLiveData.setValue(ResponseDataOfArray.error(error)),
                message -> articleListLiveData.setValue(ResponseDataOfArray.error(message))
        );
    }

    public List<ArticleModel> getLocalArticleList() {
        return articleRepository.getLocalArticleList();
    }
}
