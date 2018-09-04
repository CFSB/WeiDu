package com.bw.movie.ui.cinema.interactor.allcinemamodel;

import com.bw.movie.ui.cinema.cinmerbean.AllCinemaBean;

/**
 * @author BySevenroup小小
 * @create 2018/9/3 20:24
 * @Description
 */
public interface IAllCinemaFragmentInteractor {
    //请求成功
    void getAllCinemaSuc(AllCinemaBean allCinemaBean);
    //请求失败
    void getAllCinemaErr(String  errMsg);
}
