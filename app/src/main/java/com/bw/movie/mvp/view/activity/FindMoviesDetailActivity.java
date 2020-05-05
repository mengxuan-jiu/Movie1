package com.bw.movie.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bw.movie.Api;
import com.bw.movie.R;
import com.bw.movie.band.movieb.FindMoviesDetail;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.util.NetUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FindMoviesDetailActivity extends BaseActivity {


    @BindView(R.id.sdv)
    SimpleDraweeView sdv;
    @BindView(R.id.score)
    TextView score;
    @BindView(R.id.comment)
    TextView comment;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.lx)
    TextView lx;
    @BindView(R.id.sj)
    TextView sj;
    @BindView(R.id.dd)
    RadioButton dd;
    @BindView(R.id.bcomment)
    TextView bcomment;
    @BindView(R.id.bxzuo)
    TextView bxzuo;
    private boolean fAa;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_find_movies_detail;
    }

    @Override
    protected void initDate() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 1);
        NetUtil.getInstance().getmApiService().findMoviesDetail(Api.USERID, Api.SESSIONID, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindMoviesDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindMoviesDetail findMoviesDetail) {
                        String imageUrl = findMoviesDetail.getResult().getImageUrl();
                        sdv.setImageURI(imageUrl);

                        FindMoviesDetail.ResultBean bean = findMoviesDetail.getResult();

                        score.setText("评分" + bean.getScore());
                        comment.setText("评论" + bean.getCommentNum());
                        name.setText("name"+bean.getName());
                        lx.setText(bean.getMovieType());
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                        sj.setText(formatter.format(bean.getReleaseTime())+""+""+bean.getPlaceOrigin());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected void initView() {


    }


    @Override
    protected void onResume() {
        super.onResume();
        dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bb;
                bb=!fAa;
                dd.setChecked(bb);
                boolean checked = dd.isChecked();
                if (checked==true){

                }else {


                }
            }
        });
        

    }
}
