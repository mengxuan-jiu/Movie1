package com.bw.movie.mvp.model;

import com.bw.movie.band.FindComingSoonMovieBead;
import com.bw.movie.band.FindHotMovieBead;
import com.bw.movie.band.FindReleaseMovieBean;
import com.bw.movie.contract.IContractHomeMovie;
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
public class ModelFindHotMovie implements IContractHomeMovie.IModel {

    @Override
    public void onDate(int page, int count, IView iView) {
        NetUtil.getInstance().getmApiService().FindHotMovieBead(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindHotMovieBead>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindHotMovieBead bead) {
                        iView.onSuccess(bead);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onfDate(int page, int count, IfView ifView) {
        NetUtil.getInstance().getmApiService().FindReleaseMovieBean(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindReleaseMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindReleaseMovieBean findReleaseMovieBean) {
                        ifView.onSuccess(findReleaseMovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ifView.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDateSoon(int userId, String sessionId,int page, int count, IViewSoon iViewSoon) {
        NetUtil.getInstance().getmApiService().FindComingSoonMovieBead(userId, sessionId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindComingSoonMovieBead>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindComingSoonMovieBead findComingSoonMovieBead) {
                      iViewSoon.onSuccessSoon(findComingSoonMovieBead);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iViewSoon.onFailureSoon(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
