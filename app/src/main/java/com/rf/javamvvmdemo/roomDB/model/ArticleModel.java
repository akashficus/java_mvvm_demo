package com.rf.javamvvmdemo.roomDB.model;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Keep
@Entity(tableName = "article")
public class ArticleModel {
    @PrimaryKey
    private int articleId;
    private String title;
    private String description;
    private String date;
    private String image;

    // Constructor
    public ArticleModel(int articleId, String title, String description, String date, String image) {
        this.articleId = articleId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.image = image;
    }

    // Default Constructor
    public ArticleModel() {}

    // Getters and Setters
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
