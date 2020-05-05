package com.bw.movie;

import com.bw.movie.band.Banner;
import com.bw.movie.band.FindComingSoonMovieBead;
import com.bw.movie.band.FindHotMovieBead;
import com.bw.movie.band.FindReleaseMovieBean;
import com.bw.movie.band.LoginBand;
import com.bw.movie.band.RegisteredBand;
import com.bw.movie.band.SendOutEmailCodeBase;
import com.bw.movie.band.cinema.FindCinemaByRegion;
import com.bw.movie.band.cinema.FindCinemaInfo;
import com.bw.movie.band.cinema.FindCinemaScheduleList;
import com.bw.movie.band.cinema.FindDateList;
import com.bw.movie.band.cinema.FindRegionList;
import com.bw.movie.band.cinema.Nearby;
import com.bw.movie.band.cinema.Recommend;
import com.bw.movie.band.movieb.ComingSoon;
import com.bw.movie.band.movieb.FindHot;
import com.bw.movie.band.movieb.FindMoviesDetail;
import com.bw.movie.band.movieb.FindRelease;
import com.bw.movie.band.movieb.FindSoonMovie;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author
 * @包名 com.bw.movie
 * @MengXuanmengxuan
 * @日期2020/4/17
 * @项目名Movie
 * @类名ApiS
 * 服务
 **/
public interface ApiService {
    @GET(Api.FIND_HOT_MOVIE)
    Observable<FindHotMovieBead> FindHotMovieBead(@Query("page") int page,@Query("count")  int count);
    @GET(Api.FIND_RELEASE_MOVIE)
    Observable<FindReleaseMovieBean> FindReleaseMovieBean(@Query("page") int page, @Query("count")  int count);
    @GET(Api.FIND_COMING_SOON_MOVIE)
    Observable<FindComingSoonMovieBead> FindComingSoonMovieBead(@Header ("userId") int userId,@Header("sessionId") String sessionId,@Query("page") int page, @Query("count")  int count);

    //发送电子邮件代码
       @FormUrlEncoded
    @POST(Api.SEND_OUT_EMAIL_CODE)
    Observable<SendOutEmailCodeBase>SendOutEmailCode(@Field("email") String email);

       //注册
    @FormUrlEncoded
    @POST(Api.REGISTER)
    Observable<RegisteredBand>Registered(@Field("nickName") String nickName, @Field("pwd")
            String pwd, @Field("email")String email, @Field("code") String code);

    //登录
    @FormUrlEncoded
    @POST(Api.LOGIN)
    Observable<LoginBand>Login(@Field("email")String email, @Field("pwd") String pwd);

    //*******电影******//mobile.bwstudent.com//mobile.bwstudent.com/
    @GET("movieApi/movie/v2/findReleaseMovieList")
    Observable<FindRelease>FindRelease(@Query("page") int page , @Query("count") int count);//查找发行电影列表
    @GET(" movieApi/movie/v2/findHotMovieList")
    Observable<FindHot>findHot(@Query("page") int page , @Query("count") int count);//查找热门电影列表
    @GET("movieApi/movie/v2/findComingSoonMovieList")//userId sessionId
    Observable<ComingSoon>ComingSoon(@Header("userId")int userId, @Header("sessionId") String sessionId, @Query("page") int page , @Query("count") int count);//查找热门电影列表
    @GET("movieApi/movie/v1/findSoonMovieByCinemaId")
    Observable<FindSoonMovie>FindSoonMovie(@Query("cinemaId") int cinemaId);//查找电影详情
    //*******电影院******//


    @GET("movieApi/cinema/v1/findNearbyCinemas")
    Observable<Nearby>Nearby(@Header("userId")int userId, @Header("sessionId")
            String sessionId, @Query("page") int page, @Query("count") int count, @Query("longitude")
                                     String longitude, @Query("latitude") String latitude);

    String FINDREGIONLIST="movieApi/tool/v2/findRegionList";
    String FINDCINEMABYREGION="movieApi/cinema/v2/findCinemaByRegion";
    @GET("movieApi/cinema/v1/findCinemaInfo")//查找电影院信息
    Observable<FindCinemaInfo>FindCinemaInfo (
            @Header("userId")int userId
            ,@Header("sessionId") String sessionId
            ,@Query("cinemaId") int cinemaId );
    @GET("movieApi/cinema/v2/findCinemaScheduleList")
    Observable<FindCinemaScheduleList>FindCinemaScheduleList(@Query("cinemaId") int cinemaId, @Query("page") int page, @Query("count") int count);
    @GET("movieApi/tool/v2/findDateList")
    Observable<FindDateList>FindDateList ();
    @GET(FINDREGIONLIST)
    Observable<FindRegionList> FindRegionList();
    @GET(FINDCINEMABYREGION)
    Observable<FindCinemaByRegion> FindCinemaByRegion(@Query("regionId") int regionId);
    @GET("movieApi/cinema/v1/findRecommendCinemas")// 推荐mobile.bwstudent.com/movieApi/cinema/v1/findNearbyCinemas
    Observable<Recommend>Recommend(@Header("userId")int userId,
                                   @Header("sessionId") String sessionId, @Query("page")
                                           int page, @Query("count") int count);
    @GET("movieApi/tool/v2/banner")
    Observable<Banner> Banner();

    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<FindMoviesDetail> findMoviesDetail
            (@Header("userId")int userId, @Header("sessionId") String sessionId
                    ,@Query("movieId") int movieId);
}
