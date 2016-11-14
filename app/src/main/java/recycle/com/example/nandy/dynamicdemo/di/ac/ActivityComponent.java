package recycle.com.example.nandy.dynamicdemo.di.ac;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Component;
import recycle.com.example.nandy.dynamicdemo.App;
import recycle.com.example.nandy.dynamicdemo.base.BaseAppCompatActivity;
import recycle.com.example.nandy.dynamicdemo.di.ActivityScope;
import recycle.com.example.nandy.dynamicdemo.di.app.AppComponent;
import recycle.com.example.nandy.dynamicdemo.di.app.AppModule;

/**
 * Created by nandy on 16/11/10.
 */

//受与activity相同的生命周期
@ActivityScope
//依赖AppComponent 享有父类Module提供的类
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();        //暴漏子类类型
}
