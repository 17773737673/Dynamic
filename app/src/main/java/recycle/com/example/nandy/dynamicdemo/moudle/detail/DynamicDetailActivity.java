package recycle.com.example.nandy.dynamicdemo.moudle.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import recycle.com.example.nandy.dynamicdemo.App;
import recycle.com.example.nandy.dynamicdemo.R;
import recycle.com.example.nandy.dynamicdemo.base.BaseAppCompatActivity;
import recycle.com.example.nandy.dynamicdemo.domain.model.User;
import recycle.com.example.nandy.dynamicdemo.databinding.ActivityDynamicDetailBinding;
import recycle.com.example.nandy.dynamicdemo.utils.TUtils;

public class DynamicDetailActivity extends BaseAppCompatActivity implements DynamicDetailContract.View {

    private ActivityDynamicDetailBinding detailBinding;

    @Inject
    public DynamicDetailPresenter presenter;

    @Inject
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding = DataBindingUtil.setContentView(this, R.layout.activity_dynamic_detail);
        initInjector();
        String dynamic_msg_list = TUtils.getJson(App.getInstance(), "dynamic_msg_list");
        Log.e("cxb", "list json--" + dynamic_msg_list);
    }

    private void initInjector() {
        DynamicDetailComponent build = DaggerDynamicDetailComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .dynamicDetailModule(new DynamicDetailModule(this, detailBinding))
                .build();
        build.inject(this);
        initPresenter(presenter);
        detailBinding.setUser(user);
    }
}
