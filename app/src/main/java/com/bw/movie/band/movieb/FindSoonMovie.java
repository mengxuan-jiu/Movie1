package com.bw.movie.band.movieb;

import java.util.List;

/**
 * @包名 com.bw.movie.band.movieb
 * @MengXuanmengxuan
 * @日期2020/3/31
 * @项目名MyMovie
 * @类名FindSoonMovie
 **/
public class FindSoonMovie {

    /**
     * movieList : [{"duration":"102分钟","fare":0.09,"id":2,
     * "imageUrl":"http://mobile.bwstudent.com/images/movie/stills/mtyj/mtyj1.jpg",
     * "name":"摩天营救","releaseTime":1595174400000,
     * "summary":"在香港市中心，世界上最高、结构最复杂的摩天大楼遭到破坏，危机一触即发。威尔·索耶（道恩·强森 饰）的妻子萨拉（内芙·坎贝尔 饰）和孩子们在98层被劫为人质，直接暴露在火线上。威尔，这位战争英雄、前联邦调查局救援队员，作为大楼的安保顾问，却被诬陷纵火和谋杀。他必须奋力营救家人，为自己洗脱罪名，关乎生死存亡的高空任务就此展开。"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<MovieListBean> movieList;

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

    public List<MovieListBean> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieListBean> movieList) {
        this.movieList = movieList;
    }

    public static class MovieListBean {
        /**
         * duration : 102分钟
         * fare : 0.09
         * id : 2
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/mtyj/mtyj1.jpg
         * name : 摩天营救
         * releaseTime : 1595174400000
         * summary : 在香港市中心，世界上最高、结构最复杂的摩天大楼遭到破坏，危机一触即发。威尔·索耶（道恩·强森 饰）的妻子萨拉（内芙·坎贝尔 饰）和孩子们在98层被劫为人质，直接暴露在火线上。威尔，这位战争英雄、前联邦调查局救援队员，作为大楼的安保顾问，却被诬陷纵火和谋杀。他必须奋力营救家人，为自己洗脱罪名，关乎生死存亡的高空任务就此展开。
         */

        private String duration;
        private double fare;
        private int id;
        private String imageUrl;
        private String name;
        private long releaseTime;
        private String summary;

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public double getFare() {
            return fare;
        }

        public void setFare(double fare) {
            this.fare = fare;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}
