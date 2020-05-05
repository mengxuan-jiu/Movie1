package com.bw.movie.mvp.presenter.movie;

import com.bw.movie.band.movieb.FindRelease;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.moviec.IContractFindRelease;
import com.bw.movie.mvp.model.moviem.FindReleaseModel;


/**
 * @包名 com.bw.movie.presenter.movie
 * @MengXuanmengxuan
 * @日期2020/3/25
 * @项目名MyMovie
 * @类名FindReleasePresenter
 **/
public class FindReleasePresenter extends BasePresenter<IContractFindRelease.IView> implements IContractFindRelease.IPresent {

    private FindReleaseModel mFindReleaseModel;

    @Override
    protected void initModel() {
        mFindReleaseModel = new FindReleaseModel();
    }//电影院

    @Override
    public void LogInDate(int page, int count) {
        mFindReleaseModel.LogInDate(page, count, new IContractFindRelease.IModel.IViewLogIn() {
            @Override
            public void LogInSuccess(FindRelease findRelease) {
                view.LogInSuccess(findRelease);
            }

            @Override
            public void LogInFailure(Throwable throwable) {
               view.LogInFailure(throwable);
            }
        });
    }
}
