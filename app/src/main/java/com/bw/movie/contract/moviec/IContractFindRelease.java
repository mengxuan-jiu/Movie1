package com.bw.movie.contract.moviec;

import com.bw.movie.band.movieb.FindRelease;
import com.bw.movie.base.IBaseView;

/**
 * @包名 com.bw.movie.contract
 * @MengXuanmengxuan
 * @日期2020/3/25
 * @项目名MyMovie
 * @类名IContractLogIn
 **/
public interface IContractFindRelease {
    interface IView extends IBaseView {
        void LogInSuccess(FindRelease findRelease);
        void LogInFailure(Throwable throwable);


    }

    interface IPresent{

        void LogInDate(int page, int count);
    }

    interface IModel{

        void LogInDate(int page, int count, IViewLogIn iViewLogIn);
        interface IViewLogIn{
            void LogInSuccess(FindRelease findRelease);
            void LogInFailure(Throwable throwable);
        }

    }
}
