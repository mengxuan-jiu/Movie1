package com.bw.movie.contract.cinema;

import com.bw.movie.band.cinema.FindDateList;
import com.bw.movie.base.IBaseView;

/**
 * @包名 com.bw.movie.contract.cinema
 * @MengXuanmengxuan
 * @日期2020/4/7
 * @项目名MyMovie
 * @类名CinemaFindDateList
 **/
public interface CinemaFindDateList {
    interface IView extends IBaseView {

        void Success(FindDateList recommend);

        void Failure(Throwable throwable);

    }

    interface IPresent {
        void Date();

    }

    interface IModel {
        void Date(IView iView);

        interface IView {
            void Success(FindDateList recommend);

            void InFailure(Throwable throwable);
        }
    }
}
