package com.bw.movie.utils;

import com.bw.movie.api.HttpGetService;
import com.bw.movie.api.Api;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
/**
 * @author BySevenGroup
 * @create 2018/8/31 15:12
 * @Description 这是Retrofit+RxJava网络请求工具类
 */
public class HttpUtils {

    private final HttpGetService iService;

    private static class Singleton{
        private static final HttpUtils INSTANCE = new HttpUtils();
    }
    public static HttpUtils getInstance() {
        return Singleton.INSTANCE;
    }

    private HttpUtils (){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new MyLogging())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        iService = retrofit.create(HttpGetService.class);
    }

    public void getData(Observable<JsonObject> observable, Subscriber<JsonObject> subscriber) {

        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public HttpGetService getHttpGetService() {
        return iService;
    }

}
