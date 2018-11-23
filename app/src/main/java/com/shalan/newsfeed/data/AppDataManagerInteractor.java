package com.shalan.newsfeed.data;

import com.shalan.newsfeed.data.models.AppNavModel;

import java.util.List;

public interface AppDataManagerInteractor {
    List<AppNavModel> getNavItems();
}
