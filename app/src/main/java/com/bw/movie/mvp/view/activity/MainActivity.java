package com.bw.movie.mvp.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;

/**
 * @author mengxuan
 */
public class MainActivity extends BaseActivity {
    private SharedPreferences.Editor edit;
    private SharedPreferences sp;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
            edit = sp.edit();
            edit.putBoolean("isorno", true);
            edit.apply();
        }
    };

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
//引导
    @Override
    protected void initDate() {
        sp = getPreferences(MODE_PRIVATE);
        boolean isorno = sp.getBoolean("isorno", false);
        if (isorno) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            handler.sendEmptyMessageDelayed(0, 3000);

        }


    }

    @Override
    protected void initView() {

    }


}
