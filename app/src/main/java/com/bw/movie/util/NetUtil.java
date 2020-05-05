package com.bw.movie.util;

import android.text.TextUtils;

import com.bw.movie.Api;
import com.bw.movie.ApiService;
import com.bw.movie.App;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author
 * @包名 com.bw.movie.util
 * @MengXuanmengxuan
 * @日期2020/4/17
 * @项目名Movie
 * @类名NetUtil
 **/
public class NetUtil {

    private final ApiService mApiService;

    private static final class PrivateNetUtil {
        private static final NetUtil NET_UTIL = new NetUtil();
    }

    public static NetUtil getInstance() {
        return PrivateNetUtil.NET_UTIL;
    }
    public NetUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    public ApiService getmApiService() {
        return mApiService;
    }


}
