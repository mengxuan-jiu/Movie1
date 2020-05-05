package com.bw.movie.mvp.view.fragnet.cinema;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.cinema.Nearby;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.cinema.IContractNearby;
import com.bw.movie.mvp.presenter.cinema.NearbyPersenter;
import com.bw.movie.mvp.view.adapter.cinema.NearAdapter;


import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearbyFragment extends BaseFragment<NearbyPersenter> implements IContractNearby.IView {


    @BindView(R.id.r_right)
    RecyclerView rRight;

    @Override
    protected void initDate() {
mPresenter.LogInDate(1, "1", 1, 10,"116.30551391385724","40.04571807462411");
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_nearby;
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected NearbyPersenter initPrenher() {
        return new NearbyPersenter();

    }


    @Override
    public void LogInSuccess(Nearby nearby) {
        String status = nearby.getStatus();

        Toast.makeText(getContext(), "status"+nearby.getStatus(), Toast.LENGTH_SHORT).show();
        List<Nearby.ResultBean> list = nearby.getResult();
        rRight.setLayoutManager(new LinearLayoutManager(getContext()));
        NearAdapter nearAdapter = new NearAdapter(list);
        rRight.setAdapter(nearAdapter);
        nearAdapter.setOnCheck(new NearAdapter.onCheck() {
            @Override
            public void getid(int i) {
//                Intent intent = new Intent(getContext(), FindCinemaInfoActivity.class);
//                intent.putExtra("yyqpi",i);
//                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void LogInFailure(Throwable throwable) {

    }
}
