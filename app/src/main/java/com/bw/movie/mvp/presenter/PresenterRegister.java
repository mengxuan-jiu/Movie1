package com.bw.movie.mvp.presenter;

import android.graphics.drawable.Icon;

import com.bw.movie.band.RegisteredBand;
import com.bw.movie.band.SendOutEmailCodeBase;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.IContractRegister;
import com.bw.movie.mvp.model.ModelRegister;

/**
 * @author mengxuan
 * @包名 com.bw.movie.mvp.presenter
 * @MengXuanmengxuan
 * @日期2020/4/18
 * @项目名Movie
 * @类名Presenter
 **/
public class PresenterRegister extends BasePresenter<IContractRegister.IView> implements IContractRegister.IPresent {

    private ModelRegister mModelRegister;

    @Override
    protected void initModel() {
        mModelRegister = new ModelRegister();
    }

    @Override
    public void onDate(String nickName, String pwd, String email, String code) {
        mModelRegister.onDate(nickName, pwd, email, code, new IContractRegister.IModel.IView() {
            @Override
            public void onSuccess(RegisteredBand bead) {
                view.onSuccess(bead);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }

    @Override
    public void onDateEmail(String email) {
        mModelRegister.onDateEmail(email, new IContractRegister.IModel.IViewEmail() {
            @Override
            public void onSuccess(SendOutEmailCodeBase bead) {
             view.onSuccessEmail(bead);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailureEmail(throwable);
            }
        });
    }
}
