package com.shalan.newsfeed.details;

import com.shalan.newsfeed.base.BasePresenter;
import com.shalan.newsfeed.data.AppDataManager;

public class DetailsPresenter<V extends DetailsViewInteractor> extends BasePresenter<V> implements DetailsPresenterInteractor<V> {

    public DetailsPresenter(AppDataManager dataManager, V viewInteractor) {
        super(dataManager, viewInteractor);
    }
}
