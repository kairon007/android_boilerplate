package cc.cloudist.app.android.boilerplate.mvp.presenter;

import android.os.Bundle;

import icepick.Icepick;

public class BaseRxPresenter<V> extends RxPresenter<V> {

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        Icepick.restoreInstanceState(this, savedState);
    }

    @Override
    protected void onSave(Bundle state) {
        super.onSave(state);
        Icepick.saveInstanceState(this, state);
    }
}
