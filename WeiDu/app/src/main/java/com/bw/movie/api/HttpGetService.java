package com.bw.movie.api;

import com.bw.movie.bean.MovieListBean;
import com.bw.movie.ui.member.act_login.bean.LoginBean;
import com.google.gson.JsonObject;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author BySevenGroup
 * @create 2018/8/31 11:41
 * @Description
 */
public interface HttpGetService {

    /**
     * 登录http://172.17.8.100/movieApi/
     * user/v1/login
     */
    @FormUrlEncoded
    @POST("user/v1/login")//用户登录
    Observable <JsonObject> getloginData(@Field("phone") String mobile,
                                         @Field("pwd") String pwd);

    //@Headers({"userId:317","sessionId:1535953498726317"})
    @GET("movie/v1/findHotMovieList")
    Observable<MovieListBean>getMovieList(@Header("userId") String userId,@Header("sessionId") String sessionId,@Query("page")String page,@Query("count")String count);
    //http://172.17.8.100/movieApi/
    /*@POST("cinema/v1/verify/findCinemaPageList")//我关注的影院
    Observable <AllCinemaData> getAllCinemaData();*/
}
