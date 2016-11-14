package recycle.com.example.nandy.dynamicdemo.data.repository;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import recycle.com.example.nandy.dynamicdemo.data.mapper.DynamicEntityDataMapper;
import recycle.com.example.nandy.dynamicdemo.data.souce.DynamicDataStoreFactory;

/**
 * Created by nandy on 16/11/11.
 */
@Singleton
public class DynamicDataRepository implements DynamicRepository {

    private final DynamicDataStoreFactory dynamicDataStoreFactory;
    private final DynamicEntityDataMapper dynamicEntityDataMapper;


    //给AppModule提供参数实例 他的两个参数都可以在AppModule中获取 有些参数类的构造需要的参数也都可以到AppModule中拿到

    @Inject
    public DynamicDataRepository(DynamicDataStoreFactory dynamicDataStoreFactory, DynamicEntityDataMapper dynamicEntityDataMapper) {
        this.dynamicDataStoreFactory = dynamicDataStoreFactory;
        this.dynamicEntityDataMapper = dynamicEntityDataMapper;
        Log.e("cxb", "inject data repository");
    }
}
