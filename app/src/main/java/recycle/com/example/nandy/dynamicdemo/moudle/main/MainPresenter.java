package recycle.com.example.nandy.dynamicdemo.moudle.main;

import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import recycle.com.example.nandy.dynamicdemo.App;
import recycle.com.example.nandy.dynamicdemo.data.mapper.DynamicEntityDataMapper;
import recycle.com.example.nandy.dynamicdemo.data.mapper.DynamicEntityJsonMapper;
import recycle.com.example.nandy.dynamicdemo.domain.model.AllTimeLine;
import recycle.com.example.nandy.dynamicdemo.domain.model.User;
import recycle.com.example.nandy.dynamicdemo.moudle.DynamicVM;
import recycle.com.example.nandy.dynamicdemo.utils.TUtils;

/**
 * Created by nandy on 16/11/16.
 */
public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;
    private final DynamicEntityJsonMapper dynamicEntityJsonMapper;
    private final DynamicEntityDataMapper dataMapper;

    @Inject
    public MainPresenter(MainContract.View view, DynamicEntityJsonMapper dynamicEntityJsonMapper,
                         DynamicEntityDataMapper dataMapper) {
        this.view = view;
        this.dynamicEntityJsonMapper = dynamicEntityJsonMapper;
        this.dataMapper = dataMapper;
    }

    public void onClick(View view) {
        Toast.makeText(this.view.getContext(), "click", Toast.LENGTH_LONG).show();
    }

    public void onClick(User user) {
        App.getInstance().getNavigator().launchToDetailActivity(view.getContext());
        Toast.makeText(this.view.getContext(), user.getAge() + "---" + user.getAvatar() + "---" + user.getName(), Toast.LENGTH_LONG).show();
    }

    /**
     * 模拟数据就直接解析assets里面json文件了
     */
    @Override
    public void getDynamicDataList() {
        String dynamic_msg_list = TUtils.getJson(App.getInstance(), "group_time_line_.json");
        AllTimeLine allTimeLine = dynamicEntityJsonMapper.fromJson(dynamic_msg_list, AllTimeLine.class);
        DynamicVM vm = dataMapper.transformVM(allTimeLine.getResult());
        view.getDynamicDataSuccess(vm);
    }
}
