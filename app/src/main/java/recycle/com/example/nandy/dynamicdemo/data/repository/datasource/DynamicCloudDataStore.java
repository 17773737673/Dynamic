package recycle.com.example.nandy.dynamicdemo.data.repository.datasource;

import recycle.com.example.nandy.dynamicdemo.data.cache.DynamicCache;

/**
 * {@link DynamicDataStore} implementation based on connections to the api (Cloud).
 * <p/>
 * 连接服务器请求层
 */
public class DynamicCloudDataStore implements DynamicDataStore {

    private DynamicCache dynamicCache;

    //服务器获取 这里的参数应该再加一个retrofit的 RestApi 可以直接调用接口之后把json后dynamicCache在写到本地
    //这里是模拟数据就不需要请求接口了
    public DynamicCloudDataStore(DynamicCache dynamicCache) {
        this.dynamicCache = dynamicCache;
    }


}
