package com.bw.movie.mvp.view.fragnet.cinema;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.bw.movie.R;
import com.bw.movie.band.cinema.Recommend;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.cinema.IContractRecommend;
import com.bw.movie.mvp.presenter.cinema.RecommendPrester;
import com.bw.movie.mvp.view.adapter.cinema.RecommendAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment<RecommendPrester> implements IContractRecommend.IView {

    @BindView(R.id.r_right)
    RecyclerView rRight;

    @Override
    protected void initDate() {

        mPresenter.LogInDate(1, "1", 1, 10);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected RecommendPrester initPrenher() {
        return new RecommendPrester();
    }


    @Override
    public void LogInSuccess(Recommend recommend) {
        String status = recommend.getStatus();

     Toast.makeText(getContext(), "status"+recommend.getStatus(), Toast.LENGTH_SHORT).show();
     List<Recommend.ResultBean> list = recommend.getResult();
     rRight.setLayoutManager(new LinearLayoutManager(getContext()));
        RecommendAdapter recommendAdapter = new RecommendAdapter(list);
        rRight.setAdapter(recommendAdapter);
        recommendAdapter.setOnCheck(new RecommendAdapter.onCheck() {
            @Override
            public void getid(int i) {

//                Intent intent = new Intent(getContext(), FindCinemaInfoActivity.class);
//                intent.putExtra("yyqpi",i);MoveFragment
//                getActivity().startActivity(intent);

            }
        });

    }

    @Override
    public void LogInFailure(Throwable throwable) {
        Toast.makeText(getContext(), "xxxx"+throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
