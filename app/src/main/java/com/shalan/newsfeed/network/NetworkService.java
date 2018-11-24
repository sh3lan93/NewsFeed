package com.shalan.newsfeed.network;


import com.shalan.newsfeed.BuildConfig;
import com.shalan.newsfeed.data.api_models.news.BaseNewsResponseModel;
import com.shalan.newsfeed.network.callbacks.NewsCallback;
import com.shalan.newsfeed.network.listeners.BaseResponseListener;

public class NetworkService {

    private static NetworkService INSTANCE;
    private RestClientConfig restClient;
    private static final String API_KEY = BuildConfig.API_KEY;
    private static final String SOURCE = BuildConfig.SOURCE;

    private NetworkService(){
        restClient = RestClientConfig.getInstance();
    }

    public static NetworkService getInstance(){
        if (INSTANCE == null)
            INSTANCE = new NetworkService();
        return INSTANCE;
    }

    public void getNews(BaseResponseListener<BaseNewsResponseModel> listener){
        APIEndPoints apiEndPoints = restClient.createService(APIEndPoints.class);
        apiEndPoints.getNews(SOURCE, API_KEY).enqueue(new NewsCallback(listener));
    }

}
