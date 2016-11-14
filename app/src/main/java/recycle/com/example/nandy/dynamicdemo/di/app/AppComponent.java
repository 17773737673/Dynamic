package recycle.com.example.nandy.dynamicdemo.di.app;

import javax.inject.Singleton;

import dagger.Component;
import recycle.com.example.nandy.dynamicdemo.App;
import recycle.com.example.nandy.dynamicdemo.base.BaseAppCompatActivity;

/**
 * Created by nandy on 16/11/10.
 */


//标记下的module 会将里面的提供类生成出来
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app);
    void inject(BaseAppCompatActivity baseAppCompatActivity);
}
