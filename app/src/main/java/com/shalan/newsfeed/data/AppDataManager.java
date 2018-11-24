package com.shalan.newsfeed.data;

import android.content.Context;

import com.shalan.newsfeed.R;
import com.shalan.newsfeed.data.api.ApiHelper;
import com.shalan.newsfeed.data.api_models.news.BaseNewsResponseModel;
import com.shalan.newsfeed.data.models.AppNavModel;
import com.shalan.newsfeed.network.listeners.BaseResponseListener;

import java.util.ArrayList;
import java.util.List;

public class AppDataManager implements AppDataManagerInteractor {

    private Context context;
    private ApiHelper apiHelper;

    public AppDataManager(Context context) {
        this.context = context;
        apiHelper = ApiHelper.getInstance();
    }

    @Override
    public List<AppNavModel> getNavItems() {
        List<AppNavModel> navList = new ArrayList<>();
        String [] navTitels = context.getResources().getStringArray(R.array.nav_titls);
        int [] navIcons = new int[]{R.drawable.explore, R.drawable.live, R.drawable.gallery, R.drawable.wishlist
                , R.drawable.e_magazine};
        int [] navIds = context.getResources().getIntArray(R.array.nav_ids);
        for (int i = 0; i < navTitels.length; i++){
            AppNavModel appNavModel = new AppNavModel(navIds[i], navIcons[i], navTitels[i]);
            navList.add(appNavModel);
        }
        return navList;
    }

    @Override
    public void getNews(BaseResponseListener<BaseNewsResponseModel> listener) {
        apiHelper.getNews(listener);
    }
}
