package com.bw.movie.mvp.presenter.movie;

import com.bw.movie.band.movieb.FindSoonMovie;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.moviec.IContractFindSoon;
import com.bw.movie.mvp.model.moviem.FindSoonModel;


/**
 * @包名 com.bw.movie.view.activity
 * @MengXuanmengxuan
 * @日期2020/3/31
 * @项目名MyMovie
 * @类名FindSoonPresenter
 **/
public class FindSoonPresenter extends BasePresenter<IContractFindSoon.IView> implements IContractFindSoon.IPresent {

    private FindSoonModel fFindSoonModel;

    @Override
    protected void initModel() {
        fFindSoonModel = new FindSoonModel();
    }

    @Override
    public void ComingSoonDate(int cinemaId) {
        fFindSoonModel.ComingSoonDate(cinemaId, new IContractFindSoon.IModel.IViewLogIn() {
            @Override
            public void ComingSoonSuccess(FindSoonMovie comingSoon) {
                view.ComingSoonSuccess(comingSoon);
            }

            @Override
            public void ComingSoonFailure(Throwable throwable) {
                view.ComingSoonFailure(throwable);
            }
        });
    }
}
