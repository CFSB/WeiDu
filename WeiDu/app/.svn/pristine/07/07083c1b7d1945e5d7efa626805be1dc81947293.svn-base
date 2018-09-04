package com.bw.movie.ui.movie.model;

import android.util.Log;

import com.bw.movie.bean.MovieListBean;
import com.bw.movie.ui.member.act_login.bean.LoginBean;
import com.bw.movie.utils.EncryptUtil;
import com.bw.movie.utils.RetrofitClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author BySevenGroup* Ice *
 * @create 2018/9/3 14:25
 * @Description
 */
public class MovieListModel {
    public void getMovieList(final InteractorCallBack callBack, int page, int count) {
        Observable<MovieListBean> movieList = RetrofitClient.getInstance().getCommonApi().getMovieList("317", "1535953498726317", page + "", count + "");
        //Observable <LoginBean> data = RetrofitClient.getInstance().getCommonApi().getloginData("18937927721", EncryptUtil.encrypt("123123"));

        movieList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber <MovieListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.getDataCallBackFai(e.toString());
                    }

                    @Override
                    public void onNext(MovieListBean listBean) {
                        Log.i("成功",listBean.getMessage());
                        callBack.getDataCallBackSuc(listBean);

                    }
                });
    }
}
