package recycle.com.example.nandy.dynamicdemo.data.repository.datasource;

/**
 * {@link DynamicDataStore} implementation based on connections to the api (Cloud).
 */
public class DynamicMixedDataStore implements DynamicDataStore {

    private final DynamicDataStore cloudDynamicDataStore;
    private final DynamicDataStore diskDynamicDataStore;

    public DynamicMixedDataStore(DynamicDataStore cloudDynamicDataStore, DynamicDataStore diskDynamicDataStore) {
        this.cloudDynamicDataStore = cloudDynamicDataStore;
        this.diskDynamicDataStore = diskDynamicDataStore;
    }

//    @Override
//    public Observable<ResultModel> getDynamicHomeData(int number, int page) {
//        return null;
//    }
}
