package com.bw.movie.mvp.view.fragnet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.Api;
import com.bw.movie.R;
import com.bw.movie.band.Banner;
import com.bw.movie.band.FindComingSoonMovieBead;
import com.bw.movie.band.FindHotMovieBead;
import com.bw.movie.band.FindReleaseMovieBean;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.contract.IContractHomeMovie;
import com.bw.movie.mvp.presenter.PresenterFindHotMovie;
import com.bw.movie.mvp.view.activity.FindMoviesDetailActivity;
import com.bw.movie.mvp.view.activity.MovieListActivity;
import com.bw.movie.mvp.view.adapter.AdapterFindHotMovie;
import com.bw.movie.mvp.view.adapter.AdapterFindReleaseMovie;
import com.bw.movie.mvp.view.adapter.AdapterfindComingSoonMovie;
import com.bw.movie.util.NetUtil;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.BaseBannerInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 电影片段
 * List
 **/
public class FilmFragment extends BaseFragment<PresenterFindHotMovie> implements IContractHomeMovie.IView {

    @BindView(R.id.h_find_hot_movie)
    RecyclerView hFindHotMovie;
    @BindView(R.id.hot_showing)
    RecyclerView hotShowing;
    @BindView(R.id.coming_soon)
    RecyclerView comingSoon;
    @BindView(R.id.hot)
    LinearLayout hot;
    @BindView(R.id.coming)
    LinearLayout coming;
    @BindView(R.id.popular)
    LinearLayout popular;



    @Override
    protected void initDate() {
        mPresenter.onDate(1, 10);
        mPresenter.onDateRelease(1, 10);
        mPresenter.onDateSoon(Api.USERID, Api.SESSIONID, 1, 10);

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_film;
    }

    @Override
    protected void initView(View inflate) {



    }

    @Override
    protected PresenterFindHotMovie initPrenher() {
        return new PresenterFindHotMovie();
    }

    @Override
    public void onSuccessSoon(FindComingSoonMovieBead bead) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        comingSoon.setLayoutManager(linearLayoutManager);
        if ("0000".equals(bead.getStatus())) {
            List<FindComingSoonMovieBead.ResultBean> list = bead.getResult();
            Toast.makeText(getContext(), "" + bead.getMessage(), Toast.LENGTH_SHORT).show();
            AdapterfindComingSoonMovie adapterfindComingSoonMovie = new AdapterfindComingSoonMovie(list);
            comingSoon.setAdapter(adapterfindComingSoonMovie);
            adapterfindComingSoonMovie.setOnitimClickListener(new AdapterfindComingSoonMovie.onitimClickListener() {
                @Override
                public void getid(int id) {
                    Myinit(id);

                }
            });
        } else {
            Toast.makeText(getContext(), "" + bead.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onFailureSoon(Throwable throwable) {

    }

    @Override
    public void onSuccess(FindReleaseMovieBean bead) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        hotShowing.setLayoutManager(linearLayoutManager);
        if ("0000".equals(bead.getStatus())) {
            List<FindReleaseMovieBean.ResultBean> list = bead.getResult();
            Toast.makeText(getContext(), "" + bead.getMessage(), Toast.LENGTH_SHORT).show();
            AdapterFindReleaseMovie releaseMovie = new AdapterFindReleaseMovie(list);
            hotShowing.setAdapter(releaseMovie);
            releaseMovie.setOnitimClickListener(new AdapterFindReleaseMovie.onitimClickListener() {
                @Override
                public void getid(int id) {
                    Myinit(id);
                }
            });
        } else {
            Toast.makeText(getContext(), "" + bead.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailureRelease(Throwable throwable) {

    }

    @Override
    public void onSuccess(FindHotMovieBead bead) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        hFindHotMovie.setLayoutManager(linearLayoutManager);
        if ("0000".equals(bead.getStatus())) {
            List<FindHotMovieBead.ResultBean> list = bead.getResult();
            Toast.makeText(getContext(), "" + bead.getMessage(), Toast.LENGTH_SHORT).show();
            AdapterFindHotMovie adapterFindHotMovie = new AdapterFindHotMovie(list);
            hFindHotMovie.setAdapter(adapterFindHotMovie);
            adapterFindHotMovie.setOnitimClickListener(new AdapterFindHotMovie.onitimClickListener() {
                @Override
                public void getid(int id) {
                    Myinit(id);
                }
            });
        } else {//
            Toast.makeText(getContext(), "" + bead.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        Toast.makeText(getContext(), "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
    private void Myinit(int id) {
        Intent intent = new Intent(getContext(), FindMoviesDetailActivity.class);
        intent.putExtra("id",id);
        getActivity().startActivity(intent);
    }

    @OnClick({R.id.hot, R.id.coming, R.id.popular})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hot:
                jump();//跳

                break;
            case R.id.coming:
                jump();//跳
                break;
            case R.id.popular:
                jump();//跳
                break;
        }
    }

    private void jump() {
        Intents.getIntents().Intent(getContext(), MovieListActivity.class, Bundle.EMPTY);

    }
}
