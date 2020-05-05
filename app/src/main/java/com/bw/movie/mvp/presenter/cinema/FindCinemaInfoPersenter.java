package com.bw.movie.mvp.presenter.cinema;

import com.bw.movie.band.cinema.FindCinemaInfo;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.cinema.CinemaFindCinemaInfo;

import com.bw.movie.mvp.model.cinema.FindCinemaInfoModle;

/**
 * @包名 com.bw.movie.presenter.cinema
 * @MengXuanmengxuan
 * @日期2020/4/9
 * @项目名MyMovie
 * @类名FindCinemaInfoPersenter
 **/
public class FindCinemaInfoPersenter extends BasePresenter<CinemaFindCinemaInfo.IView> implements CinemaFindCinemaInfo.IPresent {

    private FindCinemaInfoModle fFindCinemaInfoModle;

    @Override
    protected void initModel() {
        fFindCinemaInfoModle = new FindCinemaInfoModle();
    }

    @Override
    public void Date(int userId, String sessionId, int cinemaId) {
        fFindCinemaInfoModle.Date(userId, sessionId, cinemaId, new CinemaFindCinemaInfo.IModel.IView() {
            @Override
            public void Success(FindCinemaInfo recommend) {
                view.Success(recommend);
            }

            @Override
            public void InFailure(Throwable throwable) {
                view.Failure(throwable);
            }
        });
    }
}
