package com.shalan.newsfeed;

import android.app.Application;
import android.content.IntentFilter;

import com.shalan.newsfeed.broadcasts.ConnectivityBroadcast;
import com.shalan.newsfeed.data.AppDataManager;

public class NewsFeedApplication extends Application {

    private AppDataManager dataManager;
    private ConnectivityBroadcast connectivityBroadcast;

    @Override
    public void onCreate() {
        super.onCreate();
        dataManager = new AppDataManager(this);
        initConnectivityBroadCast();
    }

    public AppDataManager getDataManager() {
        return dataManager;
    }

    private void initConnectivityBroadCast(){

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityBroadcast.ACTION_NAME);
        this.connectivityBroadcast = new ConnectivityBroadcast();
        this.registerReceiver(connectivityBroadcast, intentFilter);

    }

    @Override
    public void onTerminate() {
        this.unregisterReceiver(connectivityBroadcast);
        super.onTerminate();
    }
}
