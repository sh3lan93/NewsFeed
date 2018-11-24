package com.shalan.newsfeed.adapters;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.shalan.newsfeed.R;
import com.shalan.newsfeed.data.api_models.news.Article;
import com.shalan.newsfeed.view_holders.ArticlesViewHolder;

public class ArticlesAdapter extends ListAdapter<Article, ArticlesViewHolder> {


    private ArticlesListener listener;

    public ArticlesAdapter(@NonNull DiffUtil.ItemCallback<Article> diffCallback, ArticlesListener listener) {
        super(diffCallback);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.article_item_view_layout, viewGroup, false);
        return new ArticlesViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticlesViewHolder articlesViewHolder, int i) {
        Article model = getItem(i);
        Glide.with(articlesViewHolder.itemView).load(model.getUrlToImage()).into(articlesViewHolder.articleImage);
        articlesViewHolder.articleTitle.setText(model.getTitle());
        articlesViewHolder.articleAuthor
                .setText(articlesViewHolder.itemView.getContext().getString(R.string.by).concat(model.getAuthor()));
        articlesViewHolder.articleDate.setText(model.getPublishedAt());
        articlesViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onArticleClicked(articlesViewHolder.getAdapterPosition());
            }
        });
    }

    public interface ArticlesListener{
        void onArticleClicked(int position);
    }
}
