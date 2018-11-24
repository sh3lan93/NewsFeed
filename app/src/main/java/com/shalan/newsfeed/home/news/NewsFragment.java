package com.shalan.newsfeed.home.news;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shalan.newsfeed.NewsFeedApplication;
import com.shalan.newsfeed.R;
import com.shalan.newsfeed.base.BaseFragment;
import com.shalan.newsfeed.data.AppDataManager;
import com.shalan.newsfeed.data.api_models.news.Article;
import com.shalan.newsfeed.home.HomeActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsFragment extends BaseFragment implements NewsViewInteractor{

    public static final String TAG = NewsFragment.class.getSimpleName();

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.app_def_toolbar)
    Toolbar appToolbar;
    @BindView(R.id.newsRecycler)
    RecyclerView newsRecycler;
    @BindView(R.id.cautionMessage)
    TextView cautionMessage;
    @BindView(R.id.loader)
    ProgressBar loader;

    private NewsPresenter<NewsViewInteractor> presenter;
    private List<Article> articlesList;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresenter();
        setupToolbar();
    }

    private void showCautionMessage(String message){
        this.loader.setVisibility(View.GONE);
        this.cautionMessage.setVisibility(View.VISIBLE);
        this.cautionMessage.setText(message);
    }

    private void hideCautionMessage(){
        this.loader.setVisibility(View.VISIBLE);
        this.cautionMessage.setVisibility(View.GONE);
    }
    private void setupToolbar() {
        ((HomeActivity)getContext()).setSupportActionBar(appToolbar);
        ActionBar mActionBar = ((HomeActivity)getContext()).getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    protected void initPresenter() {
        AppDataManager dataManager = ((NewsFeedApplication)getContext()).getDataManager();
        presenter = new NewsPresenter<NewsViewInteractor>(dataManager, this);
    }

    @Override
    protected void noConnectionAvailable() {
        showCautionMessage(getString(R.string.no_connection_available_message));
    }

    @Override
    protected void connectionAvailable() {
        hideCautionMessage();
        presenter.getNewsData();
    }

    @Override
    public void getNewsFailed(String message) {
        showCautionMessage(message);
    }

    @Override
    public void getNewsSuccess(List<Article> articleList) {
        this.loader.setVisibility(View.GONE);
        this.articlesList = articleList;
    }

    @Override
    public void getNewsIsEmpty() {
        showCautionMessage(getString(R.string.no_data_available));
    }

    public interface OnFragmentInteractionListener {
    }
}
