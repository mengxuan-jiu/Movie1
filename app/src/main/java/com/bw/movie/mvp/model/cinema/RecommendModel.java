package com.bw.movie.mvp.model.cinema;

import com.bw.movie.band.cinema.Recommend;
import com.bw.movie.contract.cinema.IContractRecommend;
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
 * @类名RecommendModel
 **/
public class RecommendModel implements IContractRecommend.IModel {
    @Override
    public void LogInDate(int userId, String sessionId, int page, int count, IViewLogIn iViewLogIn) {
        NetUtil.getInstance().getmApiService().Recommend(userId, sessionId, page, count)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Recommend>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Recommend recommend) {
                 iViewLogIn.LogInSuccess(recommend);
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
//.subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe();