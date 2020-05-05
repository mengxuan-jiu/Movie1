package com.bw.movie.mvp.model.cinema;

import com.bw.movie.band.cinema.FindDateList;
import com.bw.movie.contract.cinema.CinemaFindDateList;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @包名 com.bw.movie.model.cinema
 * @MengXuanmengxuan
 * @日期2020/4/7
 * @项目名MyMovie
 * @类名Model
 **/
public class ModelFindDateList implements CinemaFindDateList.IModel {
    @Override
    public void Date(IView iView) {
        NetUtil.getInstance().getmApiService().FindDateList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FindDateList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindDateList findDateList) {
                    iView.Success(findDateList);
                    }

                    @Override
                    public void onError(Throwable e) {
                      iView.InFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
