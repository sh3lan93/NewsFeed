package com.shalan.newsfeed.home.app_nav;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shalan.newsfeed.NewsFeedApplication;
import com.shalan.newsfeed.R;
import com.shalan.newsfeed.adapters.AppNavAdapter;
import com.shalan.newsfeed.adapters.callbacks.AppNavDiffCallbacks;
import com.shalan.newsfeed.base.BaseFragment;
import com.shalan.newsfeed.data.AppDataManager;
import com.shalan.newsfeed.data.models.AppNavModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AppNavigationFragment extends BaseFragment implements AppNavigationViewInteractor, AppNavAdapter.NavListener {

    public static final String TAG = AppNavigationFragment.class.getSimpleName();

    private static final String LAST_SELECTED_INDEX_KEY = "selectedPosition";
    private AppNavigationPresenter<AppNavigationViewInteractor> presenter;

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.navItems)
    RecyclerView navItemsRecycler;

    private AppNavDiffCallbacks callbacks;
    private AppNavAdapter adapter;
    private List<AppNavModel> navItemsList;
    private int lastSelectedIndex = -1;

    public AppNavigationFragment() {
        // Required empty public constructor
    }

    public static AppNavigationFragment newInstance() {
        AppNavigationFragment fragment = new AppNavigationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_app_navigation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey(LAST_SELECTED_INDEX_KEY))
            this.lastSelectedIndex = savedInstanceState.getInt(LAST_SELECTED_INDEX_KEY);
        initPresenter();
        configureNavRecycler();
        setSelectedIndex();
    }

    private void setSelectedIndex() {
        if (this.lastSelectedIndex == -1) {
            this.navItemsList.get(0).setSelected(true);
            this.lastSelectedIndex = 0;
        }else {
            this.navItemsList.get(this.lastSelectedIndex).setSelected(true);
            this.adapter.notifyDataSetChanged();
        }
    }

    private void configureNavRecycler() {
        navItemsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        callbacks = new AppNavDiffCallbacks();
        adapter = new AppNavAdapter(callbacks, this);
        navItemsRecycler.setAdapter(adapter);
        this.navItemsList = presenter.getAppNavItems();
        this.adapter.submitList(navItemsList);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(LAST_SELECTED_INDEX_KEY, this.lastSelectedIndex);
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
        AppDataManager dataManager = ((NewsFeedApplication)getContext().getApplicationContext()).getDataManager();
        presenter = new AppNavigationPresenter<AppNavigationViewInteractor>(dataManager, this);
    }

    @Override
    public void onClick(int position) {
        if (this.navItemsList != null) {
            this.navItemsList.get(this.lastSelectedIndex).setSelected(false);
            this.adapter.notifyItemChanged(this.lastSelectedIndex);

            this.navItemsList.get(position).setSelected(true);
            this.adapter.notifyItemChanged(position);

            this.lastSelectedIndex = position;

            this.mListener.onNavItemSelected(position, this.navItemsList.get(position).getNavTitle());
        }
    }

    public interface OnFragmentInteractionListener {
        void onNavItemSelected(int position, String navTitle);
    }
}
