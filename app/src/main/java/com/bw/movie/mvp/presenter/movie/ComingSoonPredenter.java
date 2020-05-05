package com.bw.movie.mvp.presenter.movie;

import com.bw.movie.band.movieb.ComingSoon;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.moviec.ContractComingSoon;
import com.bw.movie.mvp.model.moviem.ComingSoonModel;


/**
 * @包名 com.bw.movie.presenter.movie
 * @MengXuanmengxuan
 * @日期2020/3/25
 * @项目名MyMovie
 * @类名ComingSoonPredenter
 **/
public class ComingSoonPredenter extends BasePresenter<ContractComingSoon.IView> implements ContractComingSoon.IPresent {

    private ComingSoonModel mComingSoonModel;

    @Override
    protected void initModel() {
        mComingSoonModel = new ComingSoonModel();
    }

    @Override
    public void LogInDate(int userId, String sessionId, int page, int count) {
        mComingSoonModel.LogInDate(userId, sessionId, page, count, new ContractComingSoon.IModel.IViewLogIn() {
            @Override
            public void LogInSuccess(ComingSoon comingSoon) {
                view.LogInSuccess(comingSoon);
            }

            @Override
            public void LogInFailure(Throwable throwable) {
                view.LogInFailure(throwable);
            }
        });
    }
}
