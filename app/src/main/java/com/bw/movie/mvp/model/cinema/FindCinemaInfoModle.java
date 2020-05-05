package com.bw.movie.mvp.model.cinema;

import com.bw.movie.band.cinema.FindCinemaInfo;
import com.bw.movie.contract.cinema.CinemaFindCinemaInfo;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @包名 com.bw.movie.model.cinema
 * @MengXuanmengxuan
 * @日期2020/4/9
 * @项目名MyMovie
 * @类名FindCinemaInfoModle
 *
 **/
public class FindCinemaInfoModle implements CinemaFindCinemaInfo.IModel {


    @Override
    public void Date(int userId, String sessionId, int cinemaId, IView iView) {
        NetUtil.getInstance().getmApiService().FindCinemaInfo(userId, sessionId,cinemaId )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FindCinemaInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindCinemaInfo findCinemaInfo) {
                     iView.Success(findCinemaInfo);
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
