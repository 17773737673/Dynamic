package recycle.com.example.nandy.dynamicdemo.moudle.main;

import recycle.com.example.nandy.dynamicdemo.base.BasePresenter;
import recycle.com.example.nandy.dynamicdemo.base.BaseView;
import recycle.com.example.nandy.dynamicdemo.domain.model.AllTimeLine;
import recycle.com.example.nandy.dynamicdemo.moudle.DynamicVM;

/**
 * Created by nandy on 16/11/16.
 */
public interface MainContract {
    interface View extends BaseView {
        void getDynamicDataSuccess(DynamicVM allTimeLine);
    }

    interface Presenter extends BasePresenter {
        void getDynamicDataList();
    }
}