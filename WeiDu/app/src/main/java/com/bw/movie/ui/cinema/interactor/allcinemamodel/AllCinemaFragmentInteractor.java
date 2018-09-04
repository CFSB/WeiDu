package com.bw.movie.ui.cinema.interactor.allcinemamodel;

import com.bw.movie.ui.cinema.cinmerbean.AllCinemaBean;
import com.bw.movie.utils.RetrofitClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author BySevenroup小小
 * @create 2018/9/3 20:27
 * @Description
 */
public class AllCinemaFragmentInteractor {
    public void getAllCinemaData(final IAllCinemaFragmentInteractor AllCinemaListener) {
        Observable<AllCinemaBean> observable = RetrofitClient.getInstance().getCommonApi().getAllCinema("1", "10");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AllCinemaBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AllCinemaBean allCinemaBean) {
                        //接口回调
                        AllCinemaListener.getAllCinemaSuc(allCinemaBean);
                    }
                });
    }
}
