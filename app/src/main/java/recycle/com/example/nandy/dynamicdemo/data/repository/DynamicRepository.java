package recycle.com.example.nandy.dynamicdemo.data.repository;

import recycle.com.example.nandy.dynamicdemo.domain.model.AllTimeLine;
import rx.Observable;

/**
 * Created by nandy on 16/11/11.
 */
public interface DynamicRepository {
    Observable<AllTimeLine> getDynamicHomeData(int number, int page);
}
