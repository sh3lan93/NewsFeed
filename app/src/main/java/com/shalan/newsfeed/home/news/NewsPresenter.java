package com.shalan.newsfeed.home.news;

import com.shalan.newsfeed.base.BasePresenter;
import com.shalan.newsfeed.data.AppDataManager;

public class NewsPresenter<V extends NewsViewInteractor> extends BasePresenter<V> implements NewsPresenterInteractor<V> {

    public NewsPresenter(AppDataManager dataManager, V viewInteractor) {
        super(dataManager, viewInteractor);
    }
}
