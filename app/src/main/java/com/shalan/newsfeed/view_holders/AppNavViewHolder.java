package com.shalan.newsfeed.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shalan.newsfeed.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppNavViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.selectedIcon)
    public ImageView selectedIcon;
    @BindView(R.id.icon)
    public ImageView icon;
    @BindView(R.id.navTitle)
    public TextView navTitle;


    public AppNavViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
