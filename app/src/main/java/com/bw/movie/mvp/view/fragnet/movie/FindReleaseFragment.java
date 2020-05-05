package com.bw.movie.mvp.view.fragnet.movie;


import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.movieb.FindRelease;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.moviec.IContractFindRelease;
import com.bw.movie.mvp.presenter.movie.FindReleasePresenter;
import com.bw.movie.mvp.view.adapter.movie.FrfAdaqter;


import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindReleaseFragment extends BaseFragment<FindReleasePresenter> implements IContractFindRelease.IView {


    @BindView(R.id.f_rv)
    RecyclerView fRv;

    @Override
    protected void initDate() {
mPresenter.LogInDate(1,5);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_find_release;
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected FindReleasePresenter initPrenher() {
        return new FindReleasePresenter();
    }


    @Override
    public void LogInSuccess(FindRelease findRelease) {
        fRv.setLayoutManager(new LinearLayoutManager(getContext()));
        //FrfAdaqter
        List<FindRelease.ResultBean> list = findRelease.getResult();
        FrfAdaqter frfAdaqter = new FrfAdaqter(list);
        fRv.setAdapter(frfAdaqter);
    }

    @Override
    public void LogInFailure(Throwable throwable) {

    }
}
