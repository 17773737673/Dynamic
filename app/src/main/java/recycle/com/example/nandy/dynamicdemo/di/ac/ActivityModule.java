package recycle.com.example.nandy.dynamicdemo.di.ac;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import recycle.com.example.nandy.dynamicdemo.di.ActivityScope;

/**
 * Created by nandy on 16/11/10.
 */
@Module
public class ActivityModule {
    private final Activity activity;


    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @ActivityScope
    Activity activity() {
        return this.activity;
    }
}
