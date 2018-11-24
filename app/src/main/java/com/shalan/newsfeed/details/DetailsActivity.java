package com.shalan.newsfeed.details;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shalan.newsfeed.NewsFeedApplication;
import com.shalan.newsfeed.R;
import com.shalan.newsfeed.base.BaseActivity;
import com.shalan.newsfeed.data.AppDataManager;
import com.shalan.newsfeed.data.api_models.news.Article;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity implements DetailsViewInteractor{


    public static final String ARTICLE_KEY = "article";

    private DetailsPresenter<DetailsViewInteractor> presenter;
    private Article articleModel;

    @BindView(R.id.articleImage)
    ImageView articleImage;
    @BindView(R.id.articleDate)
    TextView articleDate;
    @BindView(R.id.articleTitle)
    TextView articleTitle;
    @BindView(R.id.articleAuthor)
    TextView articleAuthor;
    @BindView(R.id.articleDescription)
    TextView articleDescription;

    @BindView(R.id.app_def_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        setupToolbar();
        if (getIntent() != null && getIntent().hasExtra(ARTICLE_KEY))
            this.articleModel = getIntent().getParcelableExtra(ARTICLE_KEY);
        if (this.articleModel != null)
            setData();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setData() {
        Glide.with(this).load(this.articleModel.getUrlToImage()).into(articleImage);
        articleTitle.setText(articleModel.getTitle());
        articleDate.setText(articleModel.getPublishedAt());
        articleAuthor.setText(getString(R.string.by).concat(articleModel.getAuthor()));
        articleDescription.setText(articleModel.getDescription());
    }

    @OnClick(R.id.openWebsiteBtn)
    public void onOpenWebsiteClicked(){

    }

    @Override
    protected void initPresenter() {
        AppDataManager dataManager = ((NewsFeedApplication)getApplication()).getDataManager();
        presenter = new DetailsPresenter<DetailsViewInteractor>(dataManager, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.news_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        presenter = null;
        super.onPause();
    }

    @Override
    protected void onPostResume() {
        initPresenter();
        super.onPostResume();
    }
}
