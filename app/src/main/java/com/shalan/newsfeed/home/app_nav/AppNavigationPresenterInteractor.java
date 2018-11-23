package com.shalan.newsfeed.home.app_nav;

import com.shalan.newsfeed.base.BasePresenterInteractor;
import com.shalan.newsfeed.data.models.AppNavModel;

import java.util.List;

public interface AppNavigationPresenterInteractor<V extends AppNavigationViewInteractor> extends BasePresenterInteractor<V> {
    List<AppNavModel> getAppNavItems();
}
