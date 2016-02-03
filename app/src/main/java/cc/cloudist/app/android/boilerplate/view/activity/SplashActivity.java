package cc.cloudist.app.android.boilerplate.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cc.cloudist.app.android.boilerplate.view.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 跳转
        startNewActivity(MainActivity.class);
    }
}
