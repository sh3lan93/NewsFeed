package com.shalan.newsfeed.adapters.callbacks;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.shalan.newsfeed.data.api_models.news.Article;

public class NewsDiffCallbacks extends DiffUtil.ItemCallback<Article> {
    @Override
    public boolean areItemsTheSame(@NonNull Article article, @NonNull Article t1) {
        return article.getTitle().equals(t1.getTitle());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Article article, @NonNull Article t1) {
        return article == t1;
    }
}
