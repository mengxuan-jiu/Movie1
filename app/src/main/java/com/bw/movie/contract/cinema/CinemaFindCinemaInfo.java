package com.bw.movie.contract.cinema;

import com.bw.movie.band.cinema.FindCinemaInfo;
import com.bw.movie.base.IBaseView;

/**
 * @包名 com.bw.movie.contract.cinema
 * @MengXuanmengxuan
 * @日期2020/4/9
 * @项目名MyMovie
 * @类名CinemaFindCinemaInfo
 **/
public interface CinemaFindCinemaInfo {
    interface IView extends IBaseView {

        void Success(FindCinemaInfo recommend);

        void Failure(Throwable throwable);

    }

    interface IPresent {
        void Date(int userId, String sessionId, int cinemaId);

    }

    interface IModel {
        void Date(int userId, String sessionId, int cinemaId, IView iView);

        interface IView {
            void Success(FindCinemaInfo recommend);

            void InFailure(Throwable throwable);
        }
    }
}
