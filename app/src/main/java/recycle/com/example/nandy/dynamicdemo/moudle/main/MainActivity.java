package recycle.com.example.nandy.dynamicdemo.moudle.main;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import recycle.com.example.nandy.dynamicdemo.R;
import recycle.com.example.nandy.dynamicdemo.base.BaseAppCompatActivity;
import recycle.com.example.nandy.dynamicdemo.iml.AppBarStateChangeListener;
import recycle.com.example.nandy.dynamicdemo.utils.StatusBarCompat;
import recycle.com.example.nandy.dynamicdemo.widget.recycleview.IRecyclerView;

/**
 * 最近项目需求写一个仿微信的朋友圈,踩了不少坑,几经周折,终于平安发布
 * 很开心 一开始github上找了许久 没有找到像样的朋友圈demo最后参照circleDemo的思路和控件
 * 顺利完成 于是就想写个完善点的demo
 * <p/>
 * demo用到的架构
 * The Clean Architecture
 * <p/>
 * <p/>
 * 把每个Activity抽出来做一个模块 给每个模块配置MVP Dagger2
 * activity的模型
 * MainActivity
 * MainContract
 * MainPresent
 * MainComponent
 * MainModule
 * <p/>
 * demo用的到技术
 * Dagger2
 * DataBinding
 * Rx
 */
public class MainActivity extends BaseAppCompatActivity {

    @Bind(R.id.news_detail_photo_iv)
    ImageView newsDetailPhotoIv;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.recycle)
    IRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void initView() {
        AppBarStatusHandle();
    }


    /**
     * 根据appbar折叠状态处理状态颜色变更
     */
    private void AppBarStatusHandle() {

        appBar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.COLLAPSED) {
                    StatusBarCompat.setStatusBarColor(MainActivity.this,
                            ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                } else if (state == State.EXPANDED) {
                    SetStatusBarColor(android.R.color.transparent);
                } else {
                    SetStatusBarColor(android.R.color.transparent);
                }
            }
        });
    }
}
