package com.bw.movie.service;

import com.bw.movie.bean.FeedBookBean;
import com.bw.movie.bean.MovieListBean;
import com.bw.movie.bean.UpdatePWDBean;
import com.bw.movie.ui.cinema.cinmerbean.AllCinemaBean;
import com.bw.movie.ui.cinema.cinmerbean.NearCinemaBean;
import com.bw.movie.ui.member.act_login.bean.LoginBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author BySevenroup小小
 * @create 2018/9/2 19:30
 * @Description
 */
public interface Service {

    /**
     * 登录http://172.17.8.100/movieApi/
     * user/v1/login
     */
    @FormUrlEncoded
    @POST("user/v1/login")
//用户登录
    Observable <LoginBean> getloginData(@Field("phone") String mobile,
                                        @Field("pwd") String pwd);

    /**
     * 介绍:附近影院相关接口
     * 接口:http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas
     * 参数:经度:longitude
     * 纬度:latitude
     * 页数:page
     * 请求数量:count
     */
    @GET("cinema/v1/findRecommendCinemas")
    Observable <NearCinemaBean> getNearCinema(@Query("longitude") String longitude,
                                              @Query("latitude") String latitude,
                                              @Query("page") String page,
                                              @Query("count") String count);

    /**
     * 介绍:全部影院相关接口
     * 接口:http://172.17.8.100/movieApi/cinema/v1/findAllCinemas
     * 参数:
     * 页数:page
     * 请求数量:count
     */
    @GET("cinema/v1/findAllCinemas")
    Observable <AllCinemaBean> getAllCinema(@Query("page") String page,
                                            @Query("count") String count);

    /*@POST()//影院数据
    Observable <AllCine> getAllCinemaData();*/
    //    option设置中的接口
    //   tool/v1/verify/recordFeedBack
    @FormUrlEncoded
    @POST("tool/v1/verify/recordFeedBack")
    Observable <FeedBookBean> getrecordFeedBack(@Header("userId") int userId,
                                                @Header("sessionId") String sessionId,
                                                @Field("content") String content);

    //修改密码
    //   user/v1/verify/modifyUserPwd
    @POST("user/v1/verify/modifyUserPwd")
    @FormUrlEncoded
    Observable <UpdatePWDBean> getModifyUserPwd(@Header("userId") int userId, @Header("sessionId") String sessionId, @Field("oldPwd") String oldPwd, @Field("newPwd") String newPwd, @Field("oldPwd2") String oldPwd2);

    @GET("movie/v1/findHotMovieList")
    Observable<MovieListBean>getMovieList(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page")String page, @Query("count")String count);
}
