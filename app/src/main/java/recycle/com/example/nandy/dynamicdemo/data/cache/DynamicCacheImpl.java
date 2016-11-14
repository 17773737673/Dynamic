package recycle.com.example.nandy.dynamicdemo.data.cache;

import android.content.Context;
import android.util.Log;

import com.google.gson.reflect.TypeToken;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import recycle.com.example.nandy.dynamicdemo.data.executor.ThreadExecutor;
import recycle.com.example.nandy.dynamicdemo.data.json.DynamicEntityJsonMapper;
import rx.Observable;
import rx.Subscriber;

/**
 */
@Singleton
public class DynamicCacheImpl implements DynamicCache {

    private final Context context;
    private final File cacheDir;
    private final DynamicEntityJsonMapper serializer;
    private final FileManager fileManager;
    private final ThreadExecutor threadExecutor;

    /**
     * @param context                 AppModule 中获取
     * @param unochatEntityJsonMapper 空构造直接生成
     * @param fileManager             空构造直接生成
     * @param executor                线程池AppModule中获取
     */
    @Inject
    public DynamicCacheImpl(Context context, DynamicEntityJsonMapper unochatEntityJsonMapper,
                            FileManager fileManager, ThreadExecutor executor) {
        if (context == null || unochatEntityJsonMapper == null || fileManager == null || executor == null) {
            throw new IllegalArgumentException("Invalid null parameter");
        }
        this.context = context.getApplicationContext();
        this.cacheDir = this.context.getCacheDir();
        this.serializer = unochatEntityJsonMapper;
        this.fileManager = fileManager;
        this.threadExecutor = executor;
    }

    @Override
    public <Entity, RawType> Observable<Entity> getEntity(final String entityKey, final TypeToken<RawType> typeToken) {
        return Observable.create(new Observable.OnSubscribe<Entity>() {
            @Override
            public void call(Subscriber<? super Entity> subscriber) {
                handleSubscriber(subscriber, entityKey, typeToken);
            }
        });
    }

    @Override
    public void putEntity(String entityKey, Object entityObject) {
        putFile(entityObject, getCacheFile(entityKey));
    }

    @Override
    public boolean isEntityCached(String entityKey) {
        return this.fileManager.exists(getCacheFile(entityKey));
    }

    @Override
    public boolean isEntityCacheExpired(String entityKey) {
        return false;
    }

    @Override
    public void evictCache(String entityKey) {
        evictCache(getCacheFile(entityKey));
    }

    @Override
    public synchronized void evictAll() {
        evictCache(this.cacheDir);
    }

    private <T, V> void handleSubscriber(Subscriber<T> subscriber, String entityKey, TypeToken<V> typeToken) {
        String fileContent = DynamicCacheImpl.this.fileManager.readFileContent(getCacheFile(entityKey));
        T entity = DynamicCacheImpl.this.serializer.fromJson(fileContent, typeToken.getType());
        if (entity != null) {
            subscriber.onNext(entity);
        }
        subscriber.onCompleted();
    }

    private void putFile(Object entity, File entityFile) {
        if (entity != null) {
            String jsonString = this.serializer.toJson(entity);
            executeAsynchronously(new CacheWriter(this.fileManager, entityFile, jsonString));
        }
    }

    private File getCacheFile(String fileName) {
        //这里的文件名可以根据需要修改
        File dir = new File(this.cacheDir.getPath(), "cxb");
        mkdirIfNeed(dir);
        File file = new File(dir, fileName);
        return file;
    }

    private synchronized void evictCache(File file) {
        this.executeAsynchronously(new CacheEvictor(this.fileManager, file));
    }

    /**
     * Executes a {@link Runnable} in another Thread.
     *
     * @param runnable {@link Runnable} to execute
     */
    private void executeAsynchronously(Runnable runnable) {
        this.threadExecutor.execute(runnable);
    }

    /**
     * {@link Runnable} class for writing to disk.
     */
    private static class CacheWriter implements Runnable {

        private final FileManager fileManager;
        private final File fileToWrite;
        private final String fileContent;

        CacheWriter(FileManager fileManager, File fileToWrite, String fileContent) {
            this.fileManager = fileManager;
            this.fileToWrite = fileToWrite;
            this.fileContent = fileContent;
        }

        @Override
        public void run() {
            if (fileToWrite.exists()) {
                fileToWrite.delete();
            }
            this.fileManager.writeToFile(fileToWrite, fileContent);
        }
    }

    /**
     * {@link Runnable} class for evicting one cache file 0r all the cached files of provided cache dir.
     */
    private static class CacheEvictor implements Runnable {

        private final FileManager fileManager;
        private final File cacheFile;

        CacheEvictor(FileManager fileManager, File cacheFile) {
            this.fileManager = fileManager;
            this.cacheFile = cacheFile;
        }

        @Override
        public void run() {
            if (cacheFile.isDirectory()) {
                this.fileManager.clearDirectory(this.cacheFile);
            } else {
                if (this.cacheFile.exists()) {
                    this.cacheFile.delete();
                }
            }
        }
    }


    public void mkdirIfNeed(File file) {
        if (file != null && !file.exists()) {
            mkdirIfNeed(file.getParentFile());
            file.mkdir();
        }
    }
}
