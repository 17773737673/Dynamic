package recycle.com.example.nandy.dynamicdemo.data.repository.datasource;

import recycle.com.example.nandy.dynamicdemo.data.cache.DynamicCache;

/**
 * {@link DynamicDataStore} implementation based on file system data store.
 */
public class DynamicDiskDataStore implements DynamicDataStore {

    private DynamicCache dynamicCache;

    public DynamicDiskDataStore(DynamicCache dynamicCache) {
        this.dynamicCache = dynamicCache;
    }


}
