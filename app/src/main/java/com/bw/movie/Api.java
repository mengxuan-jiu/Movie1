package com.bw.movie;

import java.net.URL;

/**
 * @author
 * @包名 com.bw.movie
 * @MengXuanmengxuan
 * @日期2020/4/17
 * @项目名Movie
 * @类名Api
 **/
public interface Api {

    String URL="http://mobile.bwstudent.com/";
    String FIND_HOT_MOVIE="movieApi/movie/v2/findHotMovieList";
    String FIND_RELEASE_MOVIE="movieApi/movie/v2/findReleaseMovieList";
    String FIND_COMING_SOON_MOVIE="movieApi/movie/v2/findComingSoonMovieList";
    String SEND_OUT_EMAIL_CODE="movieApi/user/v2/sendOutEmailCode";
    String REGISTER="movieApi/user/v2/register";
    String LOGIN="movieApi/user/v2/login";

    String SESSIONID="1";
    int USERID=1;




}
