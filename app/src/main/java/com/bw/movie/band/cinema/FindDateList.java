package com.bw.movie.band.cinema;

import java.util.List;

/**
 * @包名 com.bw.movie.band.cinema
 * @MengXuanmengxuan
 * @日期2020/4/7
 * @项目名MyMovie
 * @类名FindDateList
 **/
public class FindDateList {

    /**
     * result : ["07-23","07-24","07-25","07-26","07-27","07-28","07-29"]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<String> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
