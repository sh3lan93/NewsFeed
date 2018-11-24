package com.shalan.newsfeed.home.news;

import com.shalan.newsfeed.base.BasePresenter;
import com.shalan.newsfeed.data.AppDataManager;
import com.shalan.newsfeed.data.api_models.news.BaseNewsResponseModel;
import com.shalan.newsfeed.network.listeners.BaseResponseListener;

public class NewsPresenter<V extends NewsViewInteractor> extends BasePresenter<V> implements NewsPresenterInteractor<V>,BaseResponseListener<BaseNewsResponseModel> {

    public NewsPresenter(AppDataManager dataManager, V viewInteractor) {
        super(dataManager, viewInteractor);
    }

    @Override
    public void getNewsData() {
        getDataManager().getNews(this);
    }

    @Override
    public void onGetResponseSuccess(BaseNewsResponseModel baseNewsResponseModel) {
        if (baseNewsResponseModel.getArticles() != null && !baseNewsResponseModel.getArticles().isEmpty())
            getViewInteractor().getNewsSuccess(baseNewsResponseModel.getArticles());
        else
            getViewInteractor().getNewsIsEmpty();
    }

    @Override
    public void onGetResponseFail(String message) {
        getViewInteractor().getNewsFailed(message);
    }
}
