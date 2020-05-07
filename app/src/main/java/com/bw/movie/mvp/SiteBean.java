package com.bw.movie.mvp;

/**
 * @author mengxuan
 * @包名 com.bw.movie.mvp
 * @MengXuanmengxuan
 * @日期2020/5/5
 * @项目名Movie
 * @类名SiteBean
 **/
public class SiteBean {
    public static final int SITE_CAN_SELECT = 1;
    public static final int SITE_HAS_SAILED = 2;
    public static final int SITE_IS_SELECTED = 3;

    private int row;
    private int seat;
    private int status;


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
