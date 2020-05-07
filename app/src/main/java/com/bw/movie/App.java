package com.bw.movie;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.mvp.view.activity.LoginActivity;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author mengxuan
 * @包名 com.bw.movie
 * @MengXuanmengxuan
 * @日期2020/4/21
 * @项目名Movie
 * @类名App
 **/
public class App extends Application {
    public static Context  sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);


    }
}
