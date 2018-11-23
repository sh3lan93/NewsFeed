package com.shalan.newsfeed.home;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import com.shalan.newsfeed.NewsFeedApplication;
import com.shalan.newsfeed.R;
import com.shalan.newsfeed.base.BaseActivity;
import com.shalan.newsfeed.data.AppDataManager;
import com.shalan.newsfeed.home.app_nav.AppNavigationFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeViewInteractor
        , AppNavigationFragment.OnFragmentInteractionListener {

    @BindView(R.id.appDrawer)
    DrawerLayout appDrawer;

    private HomePresenter<HomeViewInteractor> presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initPresenter();
    }

    @Override
    protected void onPause() {
        presenter = null;
        if (appDrawer.isDrawerOpen(GravityCompat.START))
            appDrawer.closeDrawer(GravityCompat.START);
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, AppNavigationFragment.TAG
                , getSupportFragmentManager().findFragmentById(R.id.customNav));
    }

    @Override
    protected void initPresenter() {
        AppDataManager dataManager = ((NewsFeedApplication) getApplication()).getDataManager();
        presenter = new HomePresenter<HomeViewInteractor>(dataManager, this);
    }

    @Override
    public void onNavItemSelected(int position) {
        this.appDrawer.closeDrawer(GravityCompat.START);
        //TODO: implement logic here
    }

    @Override
    public void onBackPressed() {
        if (this.appDrawer.isDrawerOpen(GravityCompat.START))
            this.appDrawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}
