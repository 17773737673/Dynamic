package recycle.com.example.nandy.dynamicdemo.domain.interactor;

import recycle.com.example.nandy.dynamicdemo.data.executor.PostExecutionThread;
import recycle.com.example.nandy.dynamicdemo.data.executor.ThreadExecutor;
import recycle.com.example.nandy.dynamicdemo.data.repository.DynamicRepository;
import recycle.com.example.nandy.dynamicdemo.domain.model.AllTimeLine;
import recycle.com.example.nandy.dynamicdemo.domain.model.ResultModel;
import rx.Observable;

/**
 * Created by nandy on 16/11/25.
 */
public class ProvideDynamicHomeData extends UseCase<ProvideDynamicHomeData.RequestValues, AllTimeLine> {


    private final DynamicRepository repository;

    protected ProvideDynamicHomeData(DynamicRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<AllTimeLine> buildUseCaseObservable(RequestValues values) {
        return repository.getDynamicHomeData(values.getNumber(), values.getPage());
    }

    public static final class RequestValues implements UseCase.RequestValues {
        private int number;
        private int page;

        public int getNumber() {
            return number;
        }

        public int getPage() {
            return page;
        }
    }
}
