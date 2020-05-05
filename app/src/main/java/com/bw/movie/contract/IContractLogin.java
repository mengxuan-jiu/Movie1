package com.bw.movie.contract;

import com.bw.movie.band.FindHotMovieBead;
import com.bw.movie.band.LoginBand;
import com.bw.movie.base.IBaseView;

/**
 * @author mengxuan
 * @包名 com.bw.movie.contract
 * @MengXuanmengxuan
 * @日期2020/4/18
 * @项目名Movie
 * @类名IContract
 **/
public interface IContractLogin {
    interface IView extends IBaseView {

        void onSuccess(LoginBand bead);

        void onFailure(Throwable throwable);

    }

    interface IPresent {
        void onDate(String email,String pwd);

    }

    interface IModel {
        void onDate(String email,String pwd, IView iView);

        interface IView {
            void onSuccess(LoginBand bead);

            void onFailure(Throwable throwable);
        }
    }
}
