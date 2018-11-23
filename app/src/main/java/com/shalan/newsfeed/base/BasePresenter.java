package com.shalan.newsfeed.base;

import com.shalan.newsfeed.data.AppDataManager;

public class BasePresenter<V extends BaseViewInteractor> implements BasePresenterInteractor<V> {

    private AppDataManager dataManager;
    private V viewInteractor;

    public BasePresenter(AppDataManager dataManager, V viewInteractor) {
        this.dataManager = dataManager;
        this.viewInteractor = viewInteractor;
    }

    public AppDataManager getDataManager() {
        return dataManager;
    }

    public V getViewInteractor() {
        return viewInteractor;
    }
}
