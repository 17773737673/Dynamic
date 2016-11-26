package recycle.com.example.nandy.dynamicdemo.moudle.main;

import dagger.Component;
import recycle.com.example.nandy.dynamicdemo.di.ActivityScope;
import recycle.com.example.nandy.dynamicdemo.di.ac.ActivityModule;
import recycle.com.example.nandy.dynamicdemo.di.app.AppComponent;

/**
 * Created by nandy on 16/11/16.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
