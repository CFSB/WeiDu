package com.bw.movie.ui.movie.view;

import com.bw.movie.base.mvpbase.IView;

/**
 * @author BySevenGroup* Ice *
 * @create 2018/9/2 21:53
 * @Description
 */
public interface MovieListView extends IView {
    void getOnSuccess(Object bean);
    void getOnError(String errMsg);
}
