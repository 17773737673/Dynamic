package recycle.com.example.nandy.dynamicdemo.moudle.detail;

import dagger.Component;
import recycle.com.example.nandy.dynamicdemo.di.ActivityScope;
import recycle.com.example.nandy.dynamicdemo.di.ac.ActivityModule;
import recycle.com.example.nandy.dynamicdemo.di.app.AppComponent;
import recycle.com.example.nandy.dynamicdemo.moudle.main.MainActivity;
import recycle.com.example.nandy.dynamicdemo.moudle.main.MainModule;

/**
 * Created by nandy on 16/11/16.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, DynamicDetailModule.class})
public interface DynamicDetailComponent {
    void inject(DynamicDetailActivity mainActivity);
}
