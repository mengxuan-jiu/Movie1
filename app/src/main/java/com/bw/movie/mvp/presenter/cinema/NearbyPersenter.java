package com.bw.movie.mvp.presenter.cinema;

import com.bw.movie.band.cinema.Nearby;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.cinema.IContractNearby;
import com.bw.movie.mvp.model.cinema.NearbyModel;


/**
 * @包名 com.bw.movie.presenter
 * @MengXuanmengxuan
 * @日期2020/3/26
 * @项目名MyMovie
 * @类名NearbyPersenter
 **/
public class NearbyPersenter extends BasePresenter<IContractNearby.IView> implements IContractNearby.IPresent {

    private NearbyModel fNearbyModel;

    @Override
    protected void initModel() {
        fNearbyModel = new NearbyModel();
    }

    @Override
    public void LogInDate(int userId, String sessionId, int page, int count, String longitude, String latitude) {
        fNearbyModel.LogInDate(userId, sessionId, page, count, longitude, latitude, new IContractNearby.IModel.IViewLogIn() {
            @Override
            public void LogInSuccess(Nearby nearby) {
                view.LogInSuccess(nearby);
            }

            @Override
            public void LogInFailure(Throwable throwable) {
                view.LogInFailure(throwable);
            }
        });
    }
}
