package recycle.com.example.nandy.dynamicdemo;

import android.app.Application;

import javax.inject.Inject;

import recycle.com.example.nandy.dynamicdemo.di.app.AppComponent;
import recycle.com.example.nandy.dynamicdemo.di.app.AppModule;
import recycle.com.example.nandy.dynamicdemo.di.app.DaggerAppComponent;
import recycle.com.example.nandy.dynamicdemo.navigation.Navigator;
import recycle.com.example.nandy.dynamicdemo.utils.preference.PreferencesHelper;

/**
 * Created by nandy on 16/11/10.
 */
public class App extends Application {

    private AppComponent appComponent;

    @Inject
    Navigator navigator;

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        PreferencesHelper.init(this);
        initializeInjector();
    }

    /**
     * 初始化dagger
     */
    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getApplicationComponent() {
        return this.appComponent;
    }

    public Navigator getNavigator() {
        return this.navigator;
    }

    public static App getInstance() {
        return app;
    }
}
