package com.bw.movie.contract.moviec;

import com.bw.movie.band.movieb.FindSoonMovie;
import com.bw.movie.base.IBaseView;

/**
 * @包名 com.bw.movie.contract.moviec
 * @MengXuanmengxuan
 * @日期2020/3/31
 * @项目名MyMovie
 * @类名IContractFindSoon
 **/
public interface IContractFindSoon {

    interface IView extends IBaseView {
        void ComingSoonSuccess(FindSoonMovie comingSoon);
        void ComingSoonFailure(Throwable throwable);


    }

    interface IPresent{

        void ComingSoonDate(int cinemaId);
    }

    interface IModel{

        void ComingSoonDate(int cinemaId, IViewLogIn iViewLogIn);
        interface IViewLogIn{
            void ComingSoonSuccess(FindSoonMovie comingSoon);
            void ComingSoonFailure(Throwable throwable);
        }

    }
}
