package com.bw.movie.ui.movie.presenter;

import com.bw.movie.base.mvpbase.BasePresenter;
import com.bw.movie.ui.movie.model.InteractorCallBack;
import com.bw.movie.ui.movie.model.MovieListModel;
import com.bw.movie.ui.movie.view.MovieListView;

/**
 * @author BySevenGroup* Ice *
 * @create 2018/9/2 21:51
 * @Description
 */
public class MovieListPresenter extends BasePresenter<MovieListView> {

    private MovieListModel model;

    public MovieListPresenter(MovieListView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        model = new MovieListModel();
    }

    public void getMovieList(int page, int count) {
        model.getMovieList(new InteractorCallBack() {
            @Override
            public void getDataCallBackSuc(Object bean) {
                view.getOnSuccess(bean);
            }

            @Override
            public void getDataCallBackFai(String errMsg) {
                view.getOnError(errMsg);
            }
        }, page, count);
    }
}
