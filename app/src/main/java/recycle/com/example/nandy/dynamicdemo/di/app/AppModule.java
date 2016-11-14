package recycle.com.example.nandy.dynamicdemo.di.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import recycle.com.example.nandy.dynamicdemo.App;
import recycle.com.example.nandy.dynamicdemo.data.cache.DynamicCache;
import recycle.com.example.nandy.dynamicdemo.data.cache.DynamicCacheImpl;
import recycle.com.example.nandy.dynamicdemo.data.executor.JobExecutor;
import recycle.com.example.nandy.dynamicdemo.data.executor.PostExecutionThread;
import recycle.com.example.nandy.dynamicdemo.data.executor.ThreadExecutor;
import recycle.com.example.nandy.dynamicdemo.data.executor.UIThread;
import recycle.com.example.nandy.dynamicdemo.navigation.Navigator;
import recycle.com.example.nandy.dynamicdemo.data.repository.DynamicDataRepository;
import recycle.com.example.nandy.dynamicdemo.data.repository.DynamicRepository;

/**
 * Created by nandy on 16/11/10.
 * 你需要提供给application的实例
 */
@Module
public class AppModule {

    private App application;

    //构造
    public AppModule(App application) {
        this.application = application;
    }

    //先提供个上下文 许多类可能需要用到Context
    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    //提供个导航类  里面封装的是所有跳转activity的函数
    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }

    //提供个线程池 参数给的是该类实现类
    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    //有异步线程 再配个ui线程才完美
    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    //提供个缓存读写类
    @Provides
    @Singleton
    DynamicCache provideDynamicCache(DynamicCacheImpl dynamicCache) {
        return dynamicCache;
    }

    //数据仓库接口 所有的网络接口返回数据后都需要在他的实现类中做是否缓存处理
    @Provides
    @Singleton
    DynamicRepository provideDynamicRepository(DynamicDataRepository dynamicDataRepository) {
        return dynamicDataRepository;
    }
}
