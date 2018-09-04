package com.bw.movie.app;

import android.app.Application;

import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.ToastUtils;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author BySevenGroup
 * @create 2018/8/30 22:50
 * @Description
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        SharedPreferencesUtils.init(this);
    }
}
