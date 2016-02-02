package cc.cloudist.app.android.boilerplate.mvp.presenter;

public interface PresenterFactory<P extends Presenter> {
    P createPresenter();
}
