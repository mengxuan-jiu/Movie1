package com.bw.movie.mvp.presenter.movie;

import com.bw.movie.band.movieb.FindSeatInfo;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.moviec.ContractComingSoon;
import com.bw.movie.contract.moviec.CotractFindSeatInfo;
import com.bw.movie.mvp.model.moviem.ModelFindSeatInfo;

/**
 * @author mengxuan
 * @包名 com.bw.movie.mvp.presenter.movie
 * @MengXuanmengxuan
 * @日期2020/5/5
 * @项目名Movie
 * @类名FindSeatInfoPresenter
 **/
public class FindSeatInfoPresenter extends BasePresenter<CotractFindSeatInfo.IView> implements CotractFindSeatInfo.IPresent {

    private ModelFindSeatInfo fModelFindSeatInfo;

    @Override
    protected void initModel() {
        fModelFindSeatInfo = new ModelFindSeatInfo();
    }

    @Override
    public void LogInDate(int hallId) {
        fModelFindSeatInfo.LogInDate(hallId, new CotractFindSeatInfo.IModel.IViewLogIn() {
            @Override
            public void Success(FindSeatInfo findSeatInfo) {
                view.Success(findSeatInfo);
            }

            @Override
            public void Failure(Throwable throwable) {
                view.Failure(throwable);
            }
        });
    }
}
