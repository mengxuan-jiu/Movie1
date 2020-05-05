package com.bw.movie.mvp.model;

import com.bw.movie.band.RegisteredBand;
import com.bw.movie.band.SendOutEmailCodeBase;
import com.bw.movie.contract.IContractRegister;
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
public class ModelRegister implements IContractRegister.IModel {


    @Override
    public void onDate(String nickName, String pwd, String email, String code, IView iView) {
        NetUtil.getInstance().getmApiService().Registered(nickName, pwd, email, code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisteredBand>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisteredBand registeredBand) {
                        iView.onSuccess(registeredBand);
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
    public void onDateEmail(String email, IViewEmail iView) {
        NetUtil.getInstance().getmApiService().SendOutEmailCode(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SendOutEmailCodeBase>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SendOutEmailCodeBase sendOutEmailCodeBase) {
                        iView.onSuccess(sendOutEmailCodeBase);
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
