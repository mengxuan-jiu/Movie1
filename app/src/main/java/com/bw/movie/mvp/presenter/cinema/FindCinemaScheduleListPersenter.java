package com.bw.movie.mvp.presenter.cinema;

import com.bw.movie.band.cinema.FindCinemaScheduleList;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.cinema.IContractFindCinemaScheduleList;
import com.bw.movie.mvp.model.cinema.FindCinemaScheduleListModle;


/**
 * @包名 com.bw.movie.presenter.cinema
 * @MengXuanmengxuan
 * @日期2020/4/7
 * @项目名MyMovie
 * @类名FindCinemaScheduleListPersenter
 **/
public class FindCinemaScheduleListPersenter extends BasePresenter<IContractFindCinemaScheduleList.IView> implements IContractFindCinemaScheduleList.IPresent {

    private FindCinemaScheduleListModle fFindCinemaScheduleListModle;

    @Override
    protected void initModel() {
        fFindCinemaScheduleListModle = new FindCinemaScheduleListModle();
    }

    @Override
    public void Date(int cinemaId, int page, int count) {
        fFindCinemaScheduleListModle.Date(cinemaId, page, count, new IContractFindCinemaScheduleList.IModel.IView() {
            @Override
            public void Success(FindCinemaScheduleList recommend) {
                view.Success(recommend);
            }

            @Override
            public void InFailure(Throwable throwable) {
                view.Failure(throwable);
            }
        });
    }
}
