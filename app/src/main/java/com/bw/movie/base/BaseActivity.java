package com.bw.movie.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * @author mengxuan
 * @包名 com.bw.movie.base
 * @MengXuanmengxuan
 * @日期2020/4/19
 * @项目名Movie
 * @类名BaseActivity
 **/
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    protected P mPresenter;

    Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attached(this);
        }
        StatusBarUtil.hideFakeStatusBarView(this);
        ButterKnife.bind(this);

        initView();
        initDate();

    }

    protected abstract P initPresenter();

    protected abstract int layoutId();

    protected abstract void initDate();

    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.dttached();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    public static class Intents {

        private static Intents intents;

        public static Intents getIntents() {
            if (intents == null)
                intents = new Intents();
            return intents;
        }

        // context this, cs跳转对象 bundle 传递参数
        public void Intent(Context context, Class<?> cs, Bundle bundle) {
            Intent i = new Intent(context, cs);
            if (bundle != null)
                i.putExtras(bundle);
            context.startActivity(i);
        }


    }

    public void showDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new Dialog(this);
            mLoadingDialog.setCancelable(false);
            View v = View.inflate(this, R.layout.dialog_loading, null);
            ImageView iv = v.findViewById(R.id.image);
            Glide.with(this).asGif().load(R.mipmap.loading).into(iv);

            mLoadingDialog.addContentView(v,
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        mLoadingDialog.show();
    }

    public void hideDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }


}
