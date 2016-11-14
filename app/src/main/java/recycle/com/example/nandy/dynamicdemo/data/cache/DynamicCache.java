package recycle.com.example.nandy.dynamicdemo.data.cache;

import com.google.gson.reflect.TypeToken;

import rx.Observable;

/**
 * Created by wyf.
 */
public interface DynamicCache {
    /**
     * Gets an {@link Observable} which will emit a {@link Entity}.
     */

    <Entity, RawType> Observable<Entity> getEntity(String entityKey, TypeToken<RawType> typeToken);

    /**
     * Puts and element into the cache.
     *
     * @param entityObject Element to insert in the cache.
     */
    void putEntity(String entityKey, Object entityObject);

    /**
     * Checks if an element (User) exists in the cache.
     *
     * @return true if the element is cached, otherwise false.
     */
    boolean isEntityCached(String entityKey);

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isEntityCacheExpired(String entityKey);

    void evictCache(String entityKey);

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}
