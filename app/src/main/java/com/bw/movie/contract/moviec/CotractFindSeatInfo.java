package com.bw.movie.contract.moviec;

import com.bw.movie.band.movieb.ComingSoon;
import com.bw.movie.band.movieb.FindSeatInfo;
import com.bw.movie.base.IBaseView;

/**
 * @author mengxuan
 * @包名 com.bw.movie.contract.moviec
 * @MengXuanmengxuan
 * @日期2020/5/5
 * @项目名Movie
 * @类名CotractFindSeatInfo
 **/
public interface CotractFindSeatInfo {
    interface IView extends IBaseView {
        void Success(FindSeatInfo findSeatInfo);
        void Failure(Throwable throwable);


    }

    interface IPresent{

        void LogInDate(int hallId);
    }

    interface IModel{

        void LogInDate(int hallId, IViewLogIn iViewLogIn);
        interface IViewLogIn{
            void Success(FindSeatInfo findSeatInfo);
            void Failure(Throwable throwable);
        }

    }}
