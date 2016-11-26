package recycle.com.example.nandy.dynamicdemo.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import recycle.com.example.nandy.dynamicdemo.moudle.detail.DynamicDetailActivity;

/**
 * Created by nandy on 16/11/10.
 */

@Singleton  //单例模式
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void launchToDetailActivity(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, DynamicDetailActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            context.startActivity(intent);
        }
    }
}
