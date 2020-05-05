package com.bw.movie.contract.cinema;

import com.bw.movie.band.cinema.Nearby;
import com.bw.movie.base.IBaseView;

/**
 * @包名 com.bw.movie.contract
 * @MengXuanmengxuan
 * @日期2020/3/25
 * @项目名MyMovie
 * @类名IContractLogIn 附近
 **/
public interface IContractNearby {
    interface IView extends IBaseView {
        void LogInSuccess(Nearby nearby);
        void LogInFailure(Throwable throwable);


    }

    interface IPresent{

        void LogInDate(int userId, String sessionId, int page, int count, String longitude, String latitude);
    }

    interface IModel{

        void LogInDate(int userId, String sessionId, int page, int count, String longitude, String latitude, IViewLogIn iViewLogIn);
        interface IViewLogIn{
            void LogInSuccess(Nearby nearby);
            void LogInFailure(Throwable throwable);
        }

    }
}
