package com.bw.movie.mvp.model.cinema;

import com.bw.movie.band.cinema.FindCinemaScheduleList;
import com.bw.movie.contract.cinema.IContractFindCinemaScheduleList;
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
 * @类名FindCinemaScheduleListModle
 **/
public class FindCinemaScheduleListModle  implements IContractFindCinemaScheduleList.IModel {
    @Override
    public void Date(int cinemaId, int page, int count, IView iView) {
        NetUtil.getInstance().getmApiService().FindCinemaScheduleList(cinemaId, page, count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FindCinemaScheduleList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindCinemaScheduleList findCinemaScheduleList) {
                    iView.Success(findCinemaScheduleList);
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
