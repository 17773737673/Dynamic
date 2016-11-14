package recycle.com.example.nandy.dynamicdemo.data.souce;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import recycle.com.example.nandy.dynamicdemo.data.cache.DynamicCache;
import recycle.com.example.nandy.dynamicdemo.utils.NetWorkUtils;

/**
 * Created by wyf on 10/17/15.
 */

//工厂模式根据需要生成请求车略，
//1.createCloudDataStore只从服务器获取
//2.createMixedDataStore 混合 先从本地Json获取一边数据 再从服务器获取一遍并把Json写到本地
//3.createDiskDataStore 只从本地获取
@Singleton
public class DynamicDataStoreFactory {

    private final Context context;
    private final DynamicCache dynamicCache;

    //这两个参数在AppModule中都能拿到
    @Inject
    public DynamicDataStoreFactory(Context context, DynamicCache dynamicCache) {
        if (context == null || dynamicCache == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
        this.dynamicCache = dynamicCache;
    }


    public DynamicDataStore createCloudDataStore() {
//        RestApi restApi = new RestApiImpl(context);
//        return new DynamicCloudDataStore(restApi, unochatCache);
        return new DynamicCloudDataStore(dynamicCache);
    }

    public DynamicDataStore createMixedDataStore() {
        //没网的时候  读取离线缓存
        if (NetWorkUtils.isNetworkAvailable(context)) {
            return new DynamicMixedDataStore(createCloudDataStore(), createDiskDataStore());
        } else {
            return new DynamicDiskDataStore(dynamicCache);
        }
    }

    public DynamicDataStore createDiskDataStore() {
        return new DynamicDiskDataStore(dynamicCache);
    }
}
