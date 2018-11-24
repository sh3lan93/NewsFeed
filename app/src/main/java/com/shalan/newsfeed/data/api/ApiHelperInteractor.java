package com.shalan.newsfeed.data.api;

import com.shalan.newsfeed.data.api_models.news.BaseNewsResponseModel;
import com.shalan.newsfeed.network.listeners.BaseResponseListener;

public interface ApiHelperInteractor {
    void getNews(BaseResponseListener<BaseNewsResponseModel> listener);
}
