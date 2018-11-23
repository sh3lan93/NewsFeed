package com.shalan.newsfeed.adapters.callbacks;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.shalan.newsfeed.data.models.AppNavModel;

public class AppNavDiffCallbacks extends DiffUtil.ItemCallback<AppNavModel> {

    @Override
    public boolean areItemsTheSame(@NonNull AppNavModel appNavModel, @NonNull AppNavModel t1) {
        return appNavModel.getId() == t1.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull AppNavModel appNavModel, @NonNull AppNavModel t1) {
        return appNavModel == t1;
    }
}
