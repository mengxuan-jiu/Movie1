package com.bw.movie.mvp.view.fragnet.movie;


import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.movieb.ComingSoon;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.moviec.ContractComingSoon;
import com.bw.movie.mvp.presenter.movie.ComingSoonPredenter;
import com.bw.movie.mvp.view.adapter.movie.CSAdaqter;


import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComingSoonFragment extends BaseFragment<ComingSoonPredenter> implements ContractComingSoon.IView {

    @BindView(R.id.s_rv)
    RecyclerView sRv;

    @Override
    protected void initDate() {
mPresenter.LogInDate(1,"1",1,10);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_coming_soon;
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected ComingSoonPredenter initPrenher() {
        return new ComingSoonPredenter();
    }


    @Override
    public void LogInSuccess(ComingSoon comingSoon) {
        sRv.setLayoutManager(new LinearLayoutManager(getContext()));
        //FrfAdaqter
        List<ComingSoon.ResultBean> list = comingSoon.getResult();
        CSAdaqter csAdaqter = new CSAdaqter(list);
        sRv.setAdapter(csAdaqter);
    }

    @Override
    public void LogInFailure(Throwable throwable) {
        Toast.makeText(getContext(), ""+throwable, Toast.LENGTH_SHORT).show();
    }
}
