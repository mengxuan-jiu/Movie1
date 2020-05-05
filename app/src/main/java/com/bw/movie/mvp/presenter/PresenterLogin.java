package com.bw.movie.mvp.presenter;

import com.bw.movie.band.LoginBand;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.IContractLogin;
import com.bw.movie.mvp.model.ModelLogin;

/**
 * @author mengxuan
 * @包名 com.bw.movie.mvp.presenter
 * @MengXuanmengxuan
 * @日期2020/4/18
 * @项目名Movie
 * @类名Presenter
 **/
public class PresenterLogin extends BasePresenter<IContractLogin.IView> implements IContractLogin.IPresent {

    private ModelLogin mModelLogin;

    @Override
    protected void initModel() {
        mModelLogin = new ModelLogin();
    }


    @Override
    public void onDate(String email, String pwd) {
        mModelLogin.onDate(email, pwd, new IContractLogin.IModel.IView() {
            @Override
            public void onSuccess(LoginBand bead) {
                view.onSuccess(bead);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }
}
