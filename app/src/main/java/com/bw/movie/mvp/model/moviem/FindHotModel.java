package com.bw.movie.mvp.model.moviem;

import com.bw.movie.band.movieb.FindHot;
import com.bw.movie.contract.moviec.ContractFindHot;
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
 * @类名FindHotPresenter
 **/
public class FindHotModel implements ContractFindHot.IModel {
    @Override
    public void LogInDate(int page, int count, IViewLogIn iViewLogIn) {
        NetUtil.getInstance().getmApiService().findHot(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindHot>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindHot findHot) {
                        iViewLogIn.LogInSuccess(findHot);
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
