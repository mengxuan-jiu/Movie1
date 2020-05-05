package com.bw.movie.contract;

import com.bw.movie.band.FindComingSoonMovieBead;
import com.bw.movie.band.FindHotMovieBead;
import com.bw.movie.band.FindReleaseMovieBean;
import com.bw.movie.base.IBaseView;

import retrofit2.http.Header;

/**
 * @author mengxuan
 * @包名 com.bw.movie.contract
 * @MengXuanmengxuan
 * @日期2020/4/18
 * @项目名Movie
 * @类名IContract
 **/
public interface IContractHomeMovie {
    interface IView extends IBaseView {
        void onSuccessSoon(FindComingSoonMovieBead bead);
        //家
        void onFailureSoon(Throwable throwable);

        void onSuccess(FindReleaseMovieBean bead);
//家
        void onFailureRelease(Throwable throwable);

        void onSuccess(FindHotMovieBead bead);

        void onFailure(Throwable throwable);

    }

    interface IPresent {
        void onDate(int page,int count);
        void onDateRelease(int page, int count);
        void onDateSoon(int userId, String sessionId,int page, int count);

    }

    interface IModel {
        void onDate(int page,int count,IView iView);
        void onfDate(int page,int count,IfView ifView);
        void onDateSoon(int userId, String sessionId,int page, int count,IViewSoon iViewSoon);
        interface IfView {
            void onSuccess(FindReleaseMovieBean bead);

            void onFailure(Throwable throwable);
        }
        interface IView {
            void onSuccess(FindHotMovieBead bead);

            void onFailure(Throwable throwable);
        }
        interface IViewSoon {
            void onSuccessSoon(FindComingSoonMovieBead bead);
            //家
            void onFailureSoon(Throwable throwable);
        }
    }
}
