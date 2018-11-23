package com.shalan.newsfeed.adapters;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.shalan.newsfeed.R;
import com.shalan.newsfeed.data.models.AppNavModel;
import com.shalan.newsfeed.view_holders.AppNavViewHolder;

public class AppNavAdapter extends ListAdapter<AppNavModel, AppNavViewHolder> {

    private NavListener listener;

    public AppNavAdapter(@NonNull DiffUtil.ItemCallback<AppNavModel> diffCallback, NavListener listener) {
        super(diffCallback);
        this.listener = listener;
    }

    @NonNull
    @Override
    public AppNavViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.nav_item_view_layout, viewGroup, false);
        return new AppNavViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull final AppNavViewHolder appNavViewHolder, int i) {

        AppNavModel model = getItem(i);
        if (model.isSelected())
            appNavViewHolder.selectedIcon.setVisibility(View.VISIBLE);
        else
            appNavViewHolder.selectedIcon.setVisibility(View.GONE);
        Glide.with(appNavViewHolder.itemView).load(model.getIcon()).into(appNavViewHolder.icon);
        appNavViewHolder.navTitle.setText(model.getNavTitle());
        appNavViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(appNavViewHolder.getAdapterPosition());
            }
        });
    }

    public interface NavListener{
        void onClick(int position);
    }
}
