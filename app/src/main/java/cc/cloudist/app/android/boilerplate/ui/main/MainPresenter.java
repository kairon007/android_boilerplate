package cc.cloudist.app.android.boilerplate.ui.main;

import android.os.Bundle;

import cc.cloudist.app.android.boilerplate.data.DataManager;
import cc.cloudist.app.android.boilerplate.data.model.News;
import cc.cloudist.app.android.boilerplate.mvp.presenter.BaseRxPresenter;
import cc.cloudist.app.android.boilerplate.util.LogUtils;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

public class MainPresenter extends BaseRxPresenter<MainActivity> {

    private static final String TAG = LogUtils.makeLogTag(MainPresenter.class);

    private static final int REQUEST_ITEMS = 1;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        restartableLatestCache(REQUEST_ITEMS,
                new Func0<Observable<News>>() {
                    @Override
                    public Observable<News> call() {
                        return DataManager.getInstance().getNews()
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                },
                new Action2<MainActivity, News>() {
                    @Override
                    public void call(MainActivity activity, News news) {
                        LogUtils.d(TAG, "news : " + news.getStories().size());
                        activity.setData(news.getStories());
                    }
                },
                new Action2<MainActivity, Throwable>() {
                    @Override
                    public void call(MainActivity activity, Throwable throwable) {
                        LogUtils.d(TAG, "throwable : " + throwable.getMessage());
                        activity.onNetworkError(throwable);
                    }
                });

        if (savedState == null) start(REQUEST_ITEMS);
    }

    public void request() {
        start(REQUEST_ITEMS);
    }
}
