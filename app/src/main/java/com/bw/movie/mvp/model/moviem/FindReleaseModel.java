package com.bw.movie.mvp.model.moviem;

import com.bw.movie.band.movieb.FindRelease;
import com.bw.movie.contract.moviec.IContractFindRelease;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @包名 com.bw.movie.model
 * @MengXuanmengxuan
 * @日期2020/3/25
 * @项目名MyMovie
 * @类名FindReleaseModel
 **/
public class FindReleaseModel implements IContractFindRelease.IModel {
    @Override
    public void LogInDate(int page, int count, IViewLogIn iViewLogIn) {
        NetUtil.getInstance().getmApiService().FindRelease(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindRelease>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindRelease findRelease) {
                        iViewLogIn.LogInSuccess(findRelease);
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
