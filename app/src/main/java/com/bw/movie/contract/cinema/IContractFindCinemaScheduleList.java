package com.bw.movie.contract.cinema;

import com.bw.movie.band.cinema.FindCinemaScheduleList;
import com.bw.movie.base.IBaseView;

/**
 * @包名 com.bw.movie.contract.cinema
 * @MengXuanmengxuan
 * @日期2020/4/7
 * @项目名MyMovie
 * @类名IContractFindCinemaScheduleList
 **/
public interface IContractFindCinemaScheduleList {
    interface IView extends IBaseView {

        void Success(FindCinemaScheduleList recommend);

        void Failure(Throwable throwable);

    }

    interface IPresent {
        void Date(int cinemaId, int page, int count);

    }

    interface IModel {
        void Date(int cinemaId, int page, int count, IView iView);

        interface IView {
            void Success(FindCinemaScheduleList recommend);

            void InFailure(Throwable throwable);
        }
    }
}
