package com.bw.movie.mvp.presenter.cinema;

import com.bw.movie.band.cinema.FindCinemaByRegion;
import com.bw.movie.band.cinema.FindRegionList;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.cinema.IContractFindCinemaByRegion;
import com.bw.movie.mvp.model.cinema.ModelFindCinemaByRegion;


/**
 * @包名 com.bw.myapplication.mvp
 * @MengXuanmengxuan
 * @日期2020/4/3
 * @项目名MyApplication6
 * @类名Presenter
 **/
public class PresenterByRegion extends BasePresenter<IContractFindCinemaByRegion.IView> implements IContractFindCinemaByRegion.IPresent {

    private ModelFindCinemaByRegion fModelFindCinemaByRegion;

    @Override
    public void Date() {
        fModelFindCinemaByRegion.Date(new IContractFindCinemaByRegion.IModel.IView() {
            @Override
            public void Success(FindRegionList recommend) {
                view.Success(recommend);
            }

            @Override
            public void InFailure(Throwable throwable) {
                view.Failure(throwable);
            }
        });
    }

    @Override
    public void LogInDate(int regionId) {
        fModelFindCinemaByRegion.LogInDate(regionId, new IContractFindCinemaByRegion.IModel.IViewLogIn() {
            @Override
            public void LogInSuccess(FindCinemaByRegion recommend) {
                view.LogInSuccess(recommend);
            }

            @Override
            public void LogInFailure(Throwable throwable) {
                view.LogInFailure(throwable);
            }
        });
    }

    @Override
    protected void initModel() {
        fModelFindCinemaByRegion = new ModelFindCinemaByRegion();

    }
}
