package com.bw.movie.mvp.model;
import com.bw.movie.band.LoginBand;
import com.bw.movie.contract.IContractLogin;
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
public class ModelLogin implements IContractLogin.IModel {

    @Override
    public void onDate(String email, String pwd, IView iView) {
        NetUtil.getInstance().getmApiService().Login(email, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBand>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBand loginBand) {
                      iView.onSuccess(loginBand);
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
}
