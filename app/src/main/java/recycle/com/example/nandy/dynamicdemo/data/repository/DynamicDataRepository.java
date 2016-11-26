package recycle.com.example.nandy.dynamicdemo.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import recycle.com.example.nandy.dynamicdemo.data.mapper.DynamicEntityJsonMapper;
import recycle.com.example.nandy.dynamicdemo.data.mapper.DynamicEntityDataMapper;
import recycle.com.example.nandy.dynamicdemo.data.repository.datasource.DynamicDataStoreFactory;
import recycle.com.example.nandy.dynamicdemo.domain.model.AllTimeLine;
import rx.Observable;

/**
 * Created by nandy on 16/11/11.
 */
@Singleton
public class DynamicDataRepository implements DynamicRepository {

    private final DynamicDataStoreFactory dynamicDataStoreFactory;
    private final DynamicEntityDataMapper dynamicEntityDataMapper;
    private final DynamicEntityJsonMapper dynamicEntityJsonMapper;


    //给AppModule提供参数实例 他的两个参数都可以在AppModule中获取 有些参数类的构造需要的参数也都可以到AppModule中拿到

    @Inject
    public DynamicDataRepository(DynamicDataStoreFactory dynamicDataStoreFactory
            , DynamicEntityDataMapper dynamicEntityDataMapper, DynamicEntityJsonMapper dynamicEntityJsonMapper) {
        this.dynamicDataStoreFactory = dynamicDataStoreFactory;
        this.dynamicEntityDataMapper = dynamicEntityDataMapper;
        this.dynamicEntityJsonMapper = dynamicEntityJsonMapper;
    }


    @Override
    public Observable<AllTimeLine> getDynamicHomeData(int number, int page) {
////        DynamicDataStore mixedDataStore = dynamicDataStoreFactory.createDiskDataStore();
////        return mixedDataStore.getDynamicHomeData(number, page);
//        //这里就直接把json转换成对象返回了，
//        String json = TUtils.getJson(App.getInstance(), "dynamic_msg_list.json");
//        return dynamicEntityJsonMapper.fromJson(json, new TypeToken<Observable<AllTimeLine>>() {
//        });

        return null;
    }
}
