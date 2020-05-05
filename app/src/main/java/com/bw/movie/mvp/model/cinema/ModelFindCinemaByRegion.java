package com.bw.movie.mvp.model.cinema;

import com.bw.movie.band.cinema.FindCinemaByRegion;
import com.bw.movie.band.cinema.FindRegionList;
import com.bw.movie.contract.cinema.IContractFindCinemaByRegion;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @包名 com.bw.myapplication.mvp
 * @MengXuanmengxuan
 * @日期2020/4/2
 * @项目名MyApplication6
 * @类名ModelRecommend
 **/
public class ModelFindCinemaByRegion implements IContractFindCinemaByRegion.IModel {


    @Override
    public void Date(IView iView) {
       NetUtil.getInstance().getmApiService().FindRegionList()
       .observeOn(AndroidSchedulers.mainThread())
       .subscribeOn(Schedulers.io())
       .subscribe(new Observer<FindRegionList>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(FindRegionList findRegionList) {
             iView.Success(findRegionList);
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

    @Override
    public void LogInDate(int regionId, IViewLogIn iViewLogIn) {
        NetUtil.getInstance().getmApiService().FindCinemaByRegion(regionId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FindCinemaByRegion>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindCinemaByRegion findCinemaByRegion) {
                     iViewLogIn.LogInSuccess(findCinemaByRegion);
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
