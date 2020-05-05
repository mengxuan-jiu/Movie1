package com.bw.movie.contract;

import com.bw.movie.band.FindHotMovieBead;

/**
 * @author mengxuan
 * @包名 com.bw.movie.contract
 * @MengXuanmengxuan
 * @日期2020/4/18
 * @项目名Movie
 * @类名IContract
 **/
public interface IContract {
    interface IView {

        void onSuccess(FindHotMovieBead bead);

        void onFailure(Throwable throwable);

    }

    interface IPresent {
        void onDate(int page,int count);

    }

    interface IModel {
        void onDate(int page,int count,int cinemaId,IView iView);

        interface IView {
            void onSuccess(FindHotMovieBead bead);

            void onFailure(Throwable throwable);
        }
    }
}
