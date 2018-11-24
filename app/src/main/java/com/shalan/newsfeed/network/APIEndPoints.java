package com.shalan.newsfeed.network;

import com.shalan.newsfeed.data.api_models.news.BaseNewsResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIEndPoints {
    @GET("v1/articles")
    Call<BaseNewsResponseModel> getNews(@Query("source") String source, @Query("apiKey") String apiKey);
}
