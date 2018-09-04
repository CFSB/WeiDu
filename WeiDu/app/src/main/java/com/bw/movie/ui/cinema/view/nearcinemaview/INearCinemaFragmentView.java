package com.bw.movie.ui.cinema.view.nearcinemaview;

import com.bw.movie.base.mvpbase.IView;
import com.bw.movie.ui.cinema.cinmerbean.NearCinemaBean;

/**
 * @author BySevenroup小小
 * @create 2018/9/2 20:22
 * @Description
 */
public interface INearCinemaFragmentView extends IView {
    //请求成功回调数据
    void getNearCinemaSuc(NearCinemaBean nearCinemaBean);
    //请求失败
    void getNearCinemaFail(String errMsg);
}
