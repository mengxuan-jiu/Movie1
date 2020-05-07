package com.bw.movie.mvp.view.activity;


import android.os.Bundle;

import com.bw.movie.R;
import com.bw.movie.band.movieb.FindSeatInfo;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.moviec.CotractFindSeatInfo;
import com.bw.movie.mvp.SelectSiteView;
import com.bw.movie.mvp.presenter.movie.FindSeatInfoPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindSeatInfoActivity extends BaseActivity<FindSeatInfoPresenter> implements CotractFindSeatInfo.IView {


    @BindView(R.id.select)
    SelectSiteView select;

    @Override
    protected FindSeatInfoPresenter initPresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_find_seat_info;
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void Success(FindSeatInfo findSeatInfo) {
        List<FindSeatInfo.ResultBean> list = findSeatInfo.getResult();

    }

    @Override
    public void Failure(Throwable throwable) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
