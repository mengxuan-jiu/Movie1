package com.bw.movie.mvp.presenter.cinema;

import com.bw.movie.band.cinema.Recommend;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.cinema.IContractRecommend;
import com.bw.movie.mvp.model.cinema.RecommendModel;


/**
 * @包名 com.bw.movie.presenter
 * @MengXuanmengxuan
 * @日期2020/3/26
 * @项目名MyMovie
 * @类名RecommendPrester
 **/
public class RecommendPrester extends BasePresenter<IContractRecommend.IView> implements IContractRecommend.IPresent {


    private RecommendModel mRecommendModel;

    @Override
    protected void initModel() {
        mRecommendModel = new RecommendModel();
    }

    @Override
    public void LogInDate(int userId, String sessionId, int page, int count) {
        mRecommendModel.LogInDate(userId, sessionId, page, count, new IContractRecommend.IModel.IViewLogIn() {
            @Override
            public void LogInSuccess(Recommend recommend) {
                view.LogInSuccess(recommend);
            }

            @Override
            public void LogInFailure(Throwable throwable) {
                view.LogInFailure(throwable);
            }
        });
    }
}
