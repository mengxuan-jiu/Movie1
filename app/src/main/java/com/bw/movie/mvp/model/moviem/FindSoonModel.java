package com.bw.movie.mvp.model.moviem;

import com.bw.movie.band.movieb.FindSoonMovie;
import com.bw.movie.contract.moviec.IContractFindSoon;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @包名 com.bw.movie.model.moviem
 * @MengXuanmengxuan
 * @日期2020/3/31
 * @项目名MyMovie
 * @类名FindSoonModel
 **/
public class FindSoonModel implements IContractFindSoon.IModel {
    @Override
    public void ComingSoonDate(int cinemaId, IViewLogIn iViewLogIn) {
        NetUtil.getInstance().getmApiService().FindSoonMovie(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindSoonMovie>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindSoonMovie findSoonMovie) {
                        iViewLogIn.ComingSoonSuccess(findSoonMovie);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iViewLogIn.ComingSoonFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
