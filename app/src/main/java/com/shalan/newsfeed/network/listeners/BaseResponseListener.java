package com.shalan.newsfeed.network.listeners;

public interface BaseResponseListener<T> {
    void onGetResponseSuccess(T t);
    void onGetResponseFail(String message);
}
