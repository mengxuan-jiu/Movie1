package com.bw.movie.mvp.view.fragnet.cinema;


import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.cinema.FindCinemaScheduleList;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.cinema.IContractFindCinemaScheduleList;
import com.bw.movie.mvp.presenter.cinema.FindCinemaScheduleListPersenter;
import com.bw.movie.mvp.view.adapter.cinema.CinemaScheduleListAdaqter;


import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaScheduleListFragment extends BaseFragment<FindCinemaScheduleListPersenter> implements IContractFindCinemaScheduleList.IView {


    @BindView(R.id.h_rv)
    RecyclerView hRv;

    @Override
    protected void initDate() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            int a = arguments.getInt("a");
            mPresenter.Date(a,1,10);
        }

        mPresenter.Date(1,1,10);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_cinema_schedule_list;
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected FindCinemaScheduleListPersenter initPrenher() {
        return new FindCinemaScheduleListPersenter();
    }


    @Override
    public void Success(FindCinemaScheduleList recommend) {
        hRv.setLayoutManager(new LinearLayoutManager(getContext()));
         List<FindCinemaScheduleList.ResultBean> list = recommend.getResult();
        CinemaScheduleListAdaqter cinemaScheduleListAdaqter = new CinemaScheduleListAdaqter(list);
         hRv.setAdapter(cinemaScheduleListAdaqter);
    }

    @Override
    public void Failure(Throwable throwable) {

    }

    public static CinemaScheduleListFragment getInstance(int i) {
        CinemaScheduleListFragment cinemaScheduleListFragment = new CinemaScheduleListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("a",i);
        cinemaScheduleListFragment.setArguments(bundle);
        return cinemaScheduleListFragment;
    }
}
