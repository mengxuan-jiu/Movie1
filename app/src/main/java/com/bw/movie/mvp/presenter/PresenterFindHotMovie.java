package com.bw.movie.mvp.presenter;

import com.bw.movie.band.FindComingSoonMovieBead;
import com.bw.movie.band.FindHotMovieBead;
import com.bw.movie.band.FindReleaseMovieBean;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.IContractHomeMovie;
import com.bw.movie.mvp.model.ModelFindHotMovie;

/**
 * @author mengxuan
 * @包名 com.bw.movie.mvp.presenter
 * @MengXuanmengxuan
 * @日期2020/4/18
 * @项目名Movie
 * @类名Presenter
 **/
public class PresenterFindHotMovie extends BasePresenter<IContractHomeMovie.IView> implements IContractHomeMovie.IPresent {

    private ModelFindHotMovie mModelFindHotMovie;

    @Override
    protected void initModel() {
        mModelFindHotMovie = new ModelFindHotMovie();
    }


    @Override
    public void onDate(int page, int count) {
        mModelFindHotMovie.onDate(page, count, new IContractHomeMovie.IModel.IView() {
            @Override
            public void onSuccess(FindHotMovieBead bead) {
                view.onSuccess(bead);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }

    @Override
    public void onDateRelease(int page, int count) {
        mModelFindHotMovie.onfDate(page, count, new IContractHomeMovie.IModel.IfView() {
            @Override
            public void onSuccess(FindReleaseMovieBean bead) {
                view.onSuccess(bead);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailureRelease(throwable);
            }
        });
    }

    @Override
    public void onDateSoon(int userId, String sessionId,int page, int count) {
        mModelFindHotMovie.onDateSoon(userId, sessionId, page, count, new IContractHomeMovie.IModel.IViewSoon() {
            @Override
            public void onSuccessSoon(FindComingSoonMovieBead bead) {
                view.onSuccessSoon(bead);
            }

            @Override
            public void onFailureSoon(Throwable throwable) {
                 view.onFailureSoon(throwable);
            }
        });
    }
}
