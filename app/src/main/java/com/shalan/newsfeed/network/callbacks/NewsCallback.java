package com.shalan.newsfeed.network.callbacks;

import com.shalan.newsfeed.data.api_models.news.BaseNewsResponseModel;
import com.shalan.newsfeed.network.listeners.BaseResponseListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsCallback implements Callback<BaseNewsResponseModel> {
    private BaseResponseListener<BaseNewsResponseModel> listener;

    public NewsCallback(BaseResponseListener<BaseNewsResponseModel> listener) {
        this.listener = listener;
    }

    @Override
    public void onResponse(Call<BaseNewsResponseModel> call, Response<BaseNewsResponseModel> response) {
        if (response.code() == 200 && response.body() != null)
            listener.onGetResponseSuccess(response.body());
        else
            listener.onGetResponseFail(response.message());
    }

    @Override
    public void onFailure(Call<BaseNewsResponseModel> call, Throwable t) {
        listener.onGetResponseFail(t.getLocalizedMessage());
    }
}
