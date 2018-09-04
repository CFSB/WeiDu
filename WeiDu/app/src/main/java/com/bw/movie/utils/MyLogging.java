package com.bw.movie.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author Codes-小生
 * @create 2018/8/29 19:43
 * @Description
 */
public class MyLogging implements Interceptor  {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t = System.nanoTime();
        Log.i("inter","请求地址"+request.url()+"连接"+chain.connection()+"请求头"+request.headers());
        Response proceed = chain.proceed(request);
        long t1 = System.nanoTime();
        ResponseBody responseBody = proceed.peekBody(1024 * 1024);
        Log.i("aaa","接受响应的地址"+proceed.request().url()+"Body体"+responseBody.string()+"响应时间"+(t1-t)/1e6d+"返回头信息"+proceed.headers());
        return proceed;
    }
}
