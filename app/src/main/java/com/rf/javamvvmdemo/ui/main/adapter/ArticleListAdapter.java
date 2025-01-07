package com.rf.javamvvmdemo.ui.main.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rf.javamvvmdemo.R;
import com.rf.javamvvmdemo.roomDB.model.ArticleModel;

import java.util.ArrayList;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {

    private final ArrayList<ArticleModel> articles;
    private final ArticleClickListener listener;

    public ArticleListAdapter(ArrayList<ArticleModel> articles, ArticleClickListener listener) {
        this.articles = articles;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        ArticleModel article = articles.get(position);
        holder.bind(article, listener);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private final TextView articleDate;
        private final TextView articleTitle;
        private final TextView articleDescription;
        private final ImageView articleImage;
        private final CardView cardView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            articleDate = itemView.findViewById(R.id.article_date);
            articleTitle = itemView.findViewById(R.id.article_title);
            articleDescription = itemView.findViewById(R.id.article_description);
            articleImage = itemView.findViewById(R.id.article_image);
            cardView = (CardView) itemView;
        }

        public void bind(ArticleModel article, ArticleClickListener listener) {
            articleDate.setText(article.getDate());
            articleTitle.setText(article.getTitle());
            articleDescription.setText(article.getDescription());

            // Use Glide or Picasso to load image
            Glide.with(articleImage.getContext())
                    .load(article.getImage())
                    .placeholder(R.drawable.image_sample)
                    .into(articleImage);

            cardView.setOnClickListener(v -> listener.onArticleClick(article));
        }
    }

    public interface ArticleClickListener {
        void onArticleClick(ArticleModel article);
    }
}
