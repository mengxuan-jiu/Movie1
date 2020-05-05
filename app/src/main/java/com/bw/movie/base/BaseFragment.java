package com.bw.movie.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author mengxuan
 * @包名 com.bw.movie.base
 * @MengXuanmengxuan
 * @日期2020/4/19
 * @项目名Movie
 * @类名BaseFragment
 **/
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    protected P mPresenter;
    public boolean isd;
    public boolean isv;
    Dialog mLoadingDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflate = inflater.inflate(layoutId(), container, false);
        mPresenter = initPrenher();
        if (mPresenter != null) {
            mPresenter.attached(this);
        }
        StatusBarUtil.hideFakeStatusBarView(getActivity());
        StatusBarUtil.setColor(getActivity(), Color.BLACK);
        StatusBarUtil.setColorForSwipeBack(getActivity(), R.color.colorAccent);

        ButterKnife.bind(this, inflate);

        initView(inflate);
        isv = true;

        return inflate;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {
            initDate();
            isd = true;
        }

    }

    /**
     *
     */
    protected abstract void initDate();

    /**
     *
     */
    protected abstract int layoutId();

    /**
     *
     */
    protected abstract void initView(View inflate);

    /**
     *
     */
    protected abstract P initPrenher();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.dttached();
        }
    }

    @SuppressWarnings("AliDeprecation")
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !isd && isv) {
            initDate();
            isd = true;
        }
    }

    public static class Intents {

        private static BaseActivity.Intents intents;

        public static BaseActivity.Intents getIntents() {
            if (intents == null)
                intents = new BaseActivity.Intents();
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

    public  void showDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new Dialog(getContext());
            mLoadingDialog.setCancelable(false);

            View inflate = View.inflate(getContext(), R.layout.dialog_loading, null);

            ImageView image = inflate.findViewById(R.id.image);
            Glide.with(this).asGif().load(R.mipmap.loading).into(image);
            mLoadingDialog.addContentView(inflate,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        mLoadingDialog.show();
    }

    public void hideDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }
}
