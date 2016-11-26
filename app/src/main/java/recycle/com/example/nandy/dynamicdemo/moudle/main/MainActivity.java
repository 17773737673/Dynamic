package recycle.com.example.nandy.dynamicdemo.moudle.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import recycle.com.example.nandy.dynamicdemo.App;
import recycle.com.example.nandy.dynamicdemo.R;
import recycle.com.example.nandy.dynamicdemo.base.BaseAppCompatActivity;
import recycle.com.example.nandy.dynamicdemo.domain.model.AllTimeLine;
import recycle.com.example.nandy.dynamicdemo.domain.model.User;
import recycle.com.example.nandy.dynamicdemo.databinding.ActivityMainBinding;
import recycle.com.example.nandy.dynamicdemo.iml.AppBarStateChangeListener;
import recycle.com.example.nandy.dynamicdemo.moudle.DynamicVM;
import recycle.com.example.nandy.dynamicdemo.utils.StatusBarCompat;
import recycle.com.example.nandy.dynamicdemo.utils.TUtils;
import recycle.com.example.nandy.dynamicdemo.widget.OnLoadMoreListener;
import recycle.com.example.nandy.dynamicdemo.widget.OnRefreshListener;

public class MainActivity extends BaseAppCompatActivity implements MainContract.View, OnLoadMoreListener, OnRefreshListener {

    private ActivityMainBinding mainBinding;

    @Inject
    public MainPresenter presenter;

    @Inject
    public MainAdapter mainAdapter;

    @Inject
    public LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initInjector();
        initView();
        AppBarStatusHandle();
    }

    private void initView() {
        mainBinding.swipeTarget.setLayoutManager(manager);
        mainBinding.swipeTarget.setAdapter(mainAdapter);
        mainBinding.swipeToLoadLayout.setOnLoadMoreListener(this);
        mainBinding.swipeToLoadLayout.setOnRefreshListener(this);
        presenter.getDynamicDataList();
    }

    private void initInjector() {
        MainComponent build = DaggerMainComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .mainModule(new MainModule(this))
                .build();
        build.inject(this);
        initPresenter(presenter);
        mainBinding.setPresent(presenter);
    }

    /**
     * 根据appbar折叠状态处理状态颜色变更
     */
    private void AppBarStatusHandle() {
        mainBinding.appBar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.COLLAPSED) {
                    mainBinding.swipeToLoadLayout.setRefreshEnabled(false);
                    StatusBarCompat.setStatusBarColor(MainActivity.this,
                            ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                } else if (state == State.EXPANDED) {
                    mainBinding.swipeToLoadLayout.setRefreshEnabled(true);
                    SetStatusBarColor(android.R.color.transparent);
                } else {
                    mainBinding.swipeToLoadLayout.setRefreshEnabled(false);
                    SetStatusBarColor(android.R.color.transparent);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mainBinding.swipeToLoadLayout.isRefreshing()) {
            mainBinding.swipeToLoadLayout.setRefreshing(false);
        }
        if (mainBinding.swipeToLoadLayout.isLoadingMore()) {
            mainBinding.swipeToLoadLayout.setLoadingMore(false);
        }
    }

    @Override
    public void getDynamicDataSuccess(DynamicVM vm) {
        mainAdapter.reset(vm.getData());
    }

    @Override
    public void onLoadMore() {
        mainBinding.swipeToLoadLayout.setLoadingMore(false);
    }

    @Override
    public void onRefresh() {
        mainBinding.swipeToLoadLayout.setRefreshing(false);
    }
}
