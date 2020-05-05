package com.bw.movie.mvp.presenter.movie;

import com.bw.movie.band.movieb.FindHot;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.moviec.ContractFindHot;
import com.bw.movie.mvp.model.moviem.FindHotModel;


/**
 * @包名 com.bw.movie.presenter.movie
 * @MengXuanmengxuan
 * @日期2020/3/25
 * @项目名MyMovie
 * @类名FindReleasePresenter
 **/
public class FindHotModelPresenter extends BasePresenter<ContractFindHot.IView> implements ContractFindHot.IPresent {

    private FindHotModel mFindHotModel;

    @Override
    protected void initModel() {
        mFindHotModel = new FindHotModel();
    }

    @Override
    public void LogInDate(int page, int count) {
        mFindHotModel.LogInDate(page, count, new ContractFindHot.IModel.IViewLogIn() {
            @Override
            public void LogInSuccess(FindHot findHot) {
        view.LogInSuccess(findHot);
            }

            @Override
            public void LogInFailure(Throwable throwable) {
view.LogInFailure(throwable);
            }
        });
    }
}
