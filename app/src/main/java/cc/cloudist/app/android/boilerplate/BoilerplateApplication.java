package cc.cloudist.app.android.boilerplate;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class BoilerplateApplication extends Application {

    private static BoilerplateApplication mApplication;

    public static BoilerplateApplication getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;

        // 初始化 Facebook 图片库 Fresco
        initialFrescoConfig();
    }

    private void initialFrescoConfig() {
        Fresco.initialize(this);
    }

}
