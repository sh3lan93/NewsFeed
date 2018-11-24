package com.shalan.newsfeed.data.api;

import com.shalan.newsfeed.data.api_models.news.BaseNewsResponseModel;
import com.shalan.newsfeed.network.NetworkService;
import com.shalan.newsfeed.network.listeners.BaseResponseListener;

public class ApiHelper implements ApiHelperInteractor {

    private static ApiHelper INSTANCE;

    private ApiHelper(){

    }

    public static ApiHelper getInstance(){
        if (INSTANCE == null)
            INSTANCE = new ApiHelper();
        return INSTANCE;
    }

    @Override
    public void getNews(BaseResponseListener<BaseNewsResponseModel> listener) {
        NetworkService.getInstance().getNews(listener);
    }
}
