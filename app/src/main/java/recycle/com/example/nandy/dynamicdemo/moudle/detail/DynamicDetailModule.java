package recycle.com.example.nandy.dynamicdemo.moudle.detail;

import dagger.Module;
import dagger.Provides;
import recycle.com.example.nandy.dynamicdemo.domain.model.User;
import recycle.com.example.nandy.dynamicdemo.databinding.ActivityDynamicDetailBinding;
import recycle.com.example.nandy.dynamicdemo.di.ActivityScope;

/**
 * Created by nandy on 16/11/16.
 */
@Module
public class DynamicDetailModule {

    private final DynamicDetailContract.View mMainView;
    private final ActivityDynamicDetailBinding ActivityDynamicDetailBinding;

    public DynamicDetailModule(DynamicDetailContract.View mainView, ActivityDynamicDetailBinding detailBinding) {
        mMainView = mainView;
        ActivityDynamicDetailBinding = detailBinding;
    }

    @Provides
    @ActivityScope
    DynamicDetailContract.View provideDynamicDetailView() {
        return mMainView;
    }

    @Provides
    @ActivityScope
    ActivityDynamicDetailBinding provideActivityDynamicDetailBinding() {
        return ActivityDynamicDetailBinding;
    }

    @Provides
    @ActivityScope
    User provideUser() {
        return new User("nay", "22", "as");
    }
}
