package com.bw.movie.ui.cinema.interactor.nearmodel;

import android.util.Log;

import com.bw.movie.ui.cinema.cinmerbean.NearCinemaBean;
import com.bw.movie.ui.cinema.interactor.nearmodel.INearCinemaFragmentInteractor;
import com.bw.movie.utils.RetrofitClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author BySevenroup小小
 * @create 2018/9/2 19:52
 * @Description
 */
public class NearCinemaFragmentInteractor {
    public void getNearCinemaData(final INearCinemaFragmentInteractor NearCinemaListener,String page,String count) {
        Observable<NearCinemaBean> nearCinema = RetrofitClient.getInstance().getCommonApi().getNearCinema("116.30551391385724",
                "40.04571807462411",
                page,
                count);
        nearCinema.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NearCinemaBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("aaaaaaaaaaa","报错了");
                    }

                    @Override
                    public void onNext(NearCinemaBean nearCinemaBean) {
                        NearCinemaListener.getNearCinemaSuc(nearCinemaBean);
                    }
                });
    }
}
