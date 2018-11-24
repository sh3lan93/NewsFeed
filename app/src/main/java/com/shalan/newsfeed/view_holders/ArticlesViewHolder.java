package com.shalan.newsfeed.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shalan.newsfeed.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.articleImage)
    public ImageView articleImage;
    @BindView(R.id.articleTitle)
    public TextView articleTitle;
    @BindView(R.id.articleAuthor)
    public TextView articleAuthor;
    @BindView(R.id.articleDate)
    public TextView articleDate;

    public ArticlesViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
