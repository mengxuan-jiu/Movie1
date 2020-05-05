package com.bw.movie.mvp.view.fragnet.movie;


import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.movieb.FindHot;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.moviec.ContractFindHot;
import com.bw.movie.mvp.presenter.movie.FindHotModelPresenter;
import com.bw.movie.mvp.view.adapter.movie.HtoAdaqter;


import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinHotFragment extends BaseFragment<FindHotModelPresenter> implements ContractFindHot.IView {

    @BindView(R.id.h_rv)
    RecyclerView hRv;

    @Override
    protected void initDate() {
mPresenter.LogInDate(1,10);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_fin_hot;
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected FindHotModelPresenter initPrenher() {
        return new FindHotModelPresenter();
    }


    @Override
    public void LogInSuccess(FindHot findHot) {
        hRv.setLayoutManager(new LinearLayoutManager(getContext()));
        //FrfAdaqter
        List<FindHot.ResultBean> list = findHot.getResult();
        HtoAdaqter htoAdaqter = new HtoAdaqter(list);
        hRv.setAdapter(htoAdaqter);
        htoAdaqter.setOnItimClickListener(new HtoAdaqter.OnItimClickListener() {
            @Override
            public void getMovieId(int id) {


//                Intent intent = new Intent(getContext(), MovieActivity.class);
//                intent.putExtra("mid",id);


//                Toast.makeText(getContext(), ""+id, Toast.LENGTH_SHORT).show();
//                startActivity(intent);
            }
        });

    }

    @Override
    public void LogInFailure(Throwable throwable) {

    }
}
