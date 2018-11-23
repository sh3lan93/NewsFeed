package com.shalan.newsfeed.home.app_nav;

import com.shalan.newsfeed.base.BasePresenter;
import com.shalan.newsfeed.data.AppDataManager;
import com.shalan.newsfeed.data.models.AppNavModel;

import java.util.List;

public class AppNavigationPresenter<V extends AppNavigationViewInteractor> extends BasePresenter<V>
        implements AppNavigationPresenterInteractor<V> {

    public AppNavigationPresenter(AppDataManager dataManager, V viewInteractor) {
        super(dataManager, viewInteractor);
    }

    @Override
    public List<AppNavModel> getAppNavItems() {
        return getDataManager().getNavItems();
    }
}
