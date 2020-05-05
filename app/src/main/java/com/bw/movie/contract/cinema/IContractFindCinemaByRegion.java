package com.bw.movie.contract.cinema;
import com.bw.movie.band.cinema.FindCinemaByRegion;
import com.bw.movie.band.cinema.FindRegionList;
import com.bw.movie.base.IBaseView;

/**
 * @包名 com.bw.myapplication.mvp
 * @MengXuanmengxuan
 * @日期2020/4/2
 * @项目名MyApplication6
 * @类名IContractRecommend
 **/
public interface IContractFindCinemaByRegion {

    interface IView extends IBaseView {
        void LogInSuccess(FindCinemaByRegion recommend);
        void LogInFailure(Throwable throwable);

        void  Success(FindRegionList recommend);
        void  Failure(Throwable throwable);

    }

    interface IPresent{
        void  Date();
        void LogInDate(int regionId);
    }

    interface IModel{
        void  Date(IView iView);
        void LogInDate(int regionId, IViewLogIn iViewLogIn);
        interface IViewLogIn{
            void LogInSuccess(FindCinemaByRegion recommend);
            void LogInFailure(Throwable throwable);
        }
        interface IView{
            void  Success(FindRegionList recommend);
            void  InFailure(Throwable throwable);
        }
    }
}



