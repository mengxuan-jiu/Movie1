package com.bw.movie.mvp.view.fragnet.cinema;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.cinema.FindCinemaByRegion;
import com.bw.movie.band.cinema.FindRegionList;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.cinema.IContractFindCinemaByRegion;
import com.bw.movie.mvp.presenter.cinema.PresenterByRegion;
import com.bw.movie.mvp.view.adapter.cinema.RAdapter;
import com.bw.movie.mvp.view.adapter.cinema.RegionAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DomainFragment extends BaseFragment<PresenterByRegion> implements IContractFindCinemaByRegion.IView {

    @BindView(R.id.rvdp)
    RecyclerView rvdp;
    @BindView(R.id.rvdy)
    RecyclerView rvdy;

    @Override
    protected void initDate() {
        mPresenter.Date();
        mPresenter.LogInDate(1);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_d;
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected PresenterByRegion initPrenher() {
        return new PresenterByRegion();
    }



    @Override
    public void LogInSuccess(FindCinemaByRegion recommend) {
        Toast.makeText(getContext(), "" + recommend.getStatus(), Toast.LENGTH_SHORT).show();
        List<FindCinemaByRegion.ResultBean> list = recommend.getResult();
        rvdy.setLayoutManager(new LinearLayoutManager(getContext()));
        RAdapter rAdapter = new RAdapter(list);
        rvdy.setAdapter(rAdapter);
        rAdapter.setOnCheck(new RAdapter.onCheck() {
            @Override
            public void grtId(int id) {

            }
        });
    }

    @Override
    public void LogInFailure(Throwable throwable) {

    }

    @Override
    public void Success(FindRegionList recommend) {
        List<FindRegionList.ResultBean> list = recommend.getResult();
        rvdp.setLayoutManager(new LinearLayoutManager(getContext()));
        RegionAdapter regionAdapter = new RegionAdapter(list);
        rvdp.setAdapter(regionAdapter);
        regionAdapter.setOnRegionId(new RegionAdapter.onRegionId() {
            @Override
            public void getId(int i) {
                mPresenter.LogInDate(i);
            }

            @Override
            public void getDx(String dx) {

            }
        });
    }

    @Override
    public void Failure(Throwable throwable) {
        Toast.makeText(getContext(), "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
