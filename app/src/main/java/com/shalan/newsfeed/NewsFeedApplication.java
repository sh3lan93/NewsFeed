package com.shalan.newsfeed;

import android.app.Application;

import com.shalan.newsfeed.data.AppDataManager;

public class NewsFeedApplication extends Application {

    private AppDataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        dataManager = new AppDataManager(this);
    }

    public AppDataManager getDataManager() {
        return dataManager;
    }
}
