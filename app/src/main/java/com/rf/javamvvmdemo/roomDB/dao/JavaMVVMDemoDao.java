package com.rf.javamvvmdemo.roomDB.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.rf.javamvvmdemo.roomDB.model.ArticleModel;

import java.util.List;

@Dao
public interface JavaMVVMDemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertArticle(ArticleModel articleModel);

    @Query("SELECT  * FROM  article")
    List<ArticleModel> getLocalArticleList();
}
