package com.bw.movie.mvp.model.moviem;

import com.bw.movie.band.movieb.FindSeatInfo;
import com.bw.movie.contract.moviec.CotractFindSeatInfo;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author mengxuan
 * @包名 com.bw.movie.mvp.model
 * @MengXuanmengxuan
 * @日期2020/4/18
 * @项目名Movie
 * @类名Model
 **/
public class ModelFindSeatInfo   implements CotractFindSeatInfo.IModel {
    @Override
    public void LogInDate(int hallId, IViewLogIn iViewLogIn) {
        NetUtil.getInstance().getmApiService().FindSeatInfo(hallId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindSeatInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindSeatInfo findSeatInfo) {
                       iViewLogIn.Success(findSeatInfo);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iViewLogIn.Failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
