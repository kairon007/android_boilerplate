package cc.cloudist.app.android.boilerplate.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cc.cloudist.app.android.boilerplate.ui.base.BaseActivity;
import cc.cloudist.app.android.boilerplate.ui.main.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 跳转
        startNewActivity(MainActivity.class);
    }
}
