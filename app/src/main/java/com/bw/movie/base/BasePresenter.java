package com.bw.movie.base;

/**
 * @author mengxuan
 * @包名 com.bw.movie.base
 * @MengXuanmengxuan
 * @日期2020/4/19
 * @项目名Movie
 * @类名BasePresenter
 **/
public abstract class BasePresenter<V extends IBaseView> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    public void attached(V view) {
        this.view = view;
    }
    public void dttached() {
         view = null;
    }
    protected abstract void initModel();
}
