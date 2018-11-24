package com.shalan.newsfeed.home.news;

import com.shalan.newsfeed.base.BasePresenterInteractor;

public interface NewsPresenterInteractor<V extends NewsViewInteractor> extends BasePresenterInteractor<V> {
    void getNewsData();
}
