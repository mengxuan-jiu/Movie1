package com.bw.movie.mvp.model.moviem;

import com.bw.movie.band.movieb.ComingSoon;
import com.bw.movie.contract.moviec.ContractComingSoon;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @包名 com.bw.movie.model.moviem
 * @MengXuanmengxuan
 * @日期2020/3/25
 * @项目名MyMovie
 * @类名ComingSoonModel
 **/
public class ComingSoonModel implements ContractComingSoon.IModel {
    @Override
    public void LogInDate(int userId, String sessionId, int page, int count, IViewLogIn iViewLogIn) {
        NetUtil.getInstance().getmApiService().ComingSoon(userId, sessionId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComingSoon>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ComingSoon comingSoon) {
                        iViewLogIn.LogInSuccess(comingSoon);
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
