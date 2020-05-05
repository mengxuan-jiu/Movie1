package com.bw.movie.mvp.presenter.cinema;

import com.bw.movie.band.cinema.FindDateList;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.cinema.CinemaFindDateList;
import com.bw.movie.mvp.model.cinema.ModelFindDateList;


/**
 * @包名 com.bw.movie.presenter.cinema
 * @MengXuanmengxuan
 * @日期2020/4/7
 * @项目名MyMovie
 * @类名FindCinemaScheduleListPersenter
 **/
public class PersenterFindDateList extends BasePresenter<CinemaFindDateList.IView> implements CinemaFindDateList.IPresent {


    private ModelFindDateList fModelFindDateList;

    @Override
    protected void initModel() {
        fModelFindDateList = new ModelFindDateList();
    }


    @Override
    public void Date() {
        fModelFindDateList.Date(new CinemaFindDateList.IModel.IView() {
            @Override
            public void Success(FindDateList recommend) {
                view.Success(recommend);
            }

            @Override
            public void InFailure(Throwable throwable) {
            view.Failure(throwable);
            }
        });
    }
}
