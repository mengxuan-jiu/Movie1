package com.bw.movie.contract;

import com.bw.movie.band.FindHotMovieBead;
import com.bw.movie.band.RegisteredBand;
import com.bw.movie.band.SendOutEmailCodeBase;
import com.bw.movie.base.IBaseView;

/**
 * @author mengxuan
 * @包名 com.bw.movie.contract
 * @MengXuanmengxuan
 * @日期2020/4/18
 * @项目名Movie
 * @类名IContract
 **/
public interface IContractRegister {
    interface IView extends IBaseView {

        void onSuccess(RegisteredBand bead);

        void onFailure(Throwable throwable);

        void onSuccessEmail(SendOutEmailCodeBase bead);

        void onFailureEmail(Throwable throwable);
    }

    interface IPresent {
        void onDate(String nickName,String pwd,String email,String code);
        void onDateEmail(String email);
    }

    interface IModel {
        void onDate(String nickName,String pwd,String email,String code, IView iView);
        void onDateEmail(String email, IViewEmail iView);

        interface IViewEmail {
            void onSuccess(SendOutEmailCodeBase bead);

            void onFailure(Throwable throwable);
        }
        interface IView {
            void onSuccess(RegisteredBand bead);

            void onFailure(Throwable throwable);
        }
    }





}
