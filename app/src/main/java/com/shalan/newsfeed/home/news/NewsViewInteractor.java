package com.shalan.newsfeed.home.news;

import com.shalan.newsfeed.base.BaseViewInteractor;
import com.shalan.newsfeed.data.api_models.news.Article;

import java.util.List;

public interface NewsViewInteractor extends BaseViewInteractor {
    void getNewsFailed(String message);
    void getNewsSuccess(List<Article> articleList);
    void getNewsIsEmpty();
}
