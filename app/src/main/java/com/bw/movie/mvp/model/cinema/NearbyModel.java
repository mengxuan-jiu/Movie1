package com.bw.movie.mvp.model.cinema;

import com.bw.movie.band.cinema.Nearby;
import com.bw.movie.contract.cinema.IContractNearby;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @包名 com.bw.movie.model.cinema
 * @MengXuanmengxuan
 * @日期2020/3/26
 * @项目名MyMovie
 * @类名NearbyModel
 */
public class NearbyModel implements IContractNearby.IModel {

    @Override
    public void LogInDate(int userId, String sessionId, int page, int count, String longitude, String latitude, IViewLogIn iViewLogIn) {
        NetUtil.getInstance().getmApiService().Nearby(userId, sessionId, page, count, longitude, latitude)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Nearby>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Nearby nearby) {
                        iViewLogIn.LogInSuccess(nearby);
                    }

                    @Override
                    public void onError(Throwable e) {
                   iViewLogIn.LogInFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
