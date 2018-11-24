
package com.shalan.newsfeed.data.api_models.news;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BaseNewsResponseModel {

    @SerializedName("articles")
    private List<Article> mArticles;
    @SerializedName("sortBy")
    private String mSortBy;
    @SerializedName("source")
    private String mSource;
    @SerializedName("status")
    private String mStatus;

    public List<Article> getArticles() {
        return mArticles;
    }

    public void setArticles(List<Article> articles) {
        mArticles = articles;
    }

    public String getSortBy() {
        return mSortBy;
    }

    public void setSortBy(String sortBy) {
        mSortBy = sortBy;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
