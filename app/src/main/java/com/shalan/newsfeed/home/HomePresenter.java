package com.shalan.newsfeed.home;

import com.shalan.newsfeed.base.BasePresenter;
import com.shalan.newsfeed.data.AppDataManager;
import com.shalan.newsfeed.data.models.AppNavModel;

import java.util.List;

public class HomePresenter<V extends HomeViewInteractor> extends BasePresenter<V> implements HomePresenterInteractor<V> {

    public HomePresenter(AppDataManager dataManager, V viewInteractor) {
        super(dataManager, viewInteractor);
    }
}
