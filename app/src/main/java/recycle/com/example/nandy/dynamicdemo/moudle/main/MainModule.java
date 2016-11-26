package recycle.com.example.nandy.dynamicdemo.moudle.main;

import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;
import recycle.com.example.nandy.dynamicdemo.di.ActivityScope;

/**
 * Created by nandy on 16/11/16.
 */
@Module
public class MainModule {

    private final MainContract.View mMainView;

    public MainModule(MainContract.View mainView) {
        mMainView = mainView;
    }

    @Provides
    @ActivityScope
    MainContract.View provideMainView() {
        return mMainView;
    }

    @Provides
    @ActivityScope
    MainAdapter provideMainAdapter() {
        return new MainAdapter(mMainView.getContext());
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(mMainView.getContext());
    }
}
