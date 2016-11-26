package recycle.com.example.nandy.dynamicdemo.domain.interactor;

import recycle.com.example.nandy.dynamicdemo.data.executor.PostExecutionThread;
import recycle.com.example.nandy.dynamicdemo.data.executor.ThreadExecutor;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by wyf on 3/7/16.
 */
public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValues> {

    /**
     * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
     * This interface represents a execution unit for different use cases (this means any use case
     * in the application should implement this contract).
     * <p/>
     * By convention each UseCase implementation will return the result using a {@link rx.Subscriber}
     * that will execute its job in a background thread and will post the result in the UI thread.
     */

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private Subscription subscription = Subscriptions.empty();

    private Q mRequestValues;

    protected UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public void setRequestValues(Q requestValues) {
        mRequestValues = requestValues;
    }

    public Q getRequestValues() {
        return mRequestValues;
    }

    /**
     * Builds an {@link rx.Observable} which will be used when executing the current {@link UseCase}.
     */
    protected abstract Observable<P> buildUseCaseObservable(Q values);

    public void execute(Q requestValues, Subscriber<P> subscriber) {
        setRequestValues(requestValues);
        execute(subscriber);
    }

    /**
     * Executes the current use case.
     *
     * @param subscriber The guy who will be listen to the observable build with {@link #buildUseCaseObservable(Q)}.
     */
    public void execute(Subscriber<P> subscriber) {
        this.subscription = this.buildUseCaseObservable(mRequestValues)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    /**
     * Data passed to a request.
     */
    public interface RequestValues {
    }

    /**
     * Data passed to a response.
     */
    public interface ResponseValues {
    }
}
