package com.bw.movie.ui.cinema.presenter.allcinemapresenter;

import android.content.Context;

import com.bw.movie.base.mvpbase.BasePresenter;
import com.bw.movie.ui.cinema.cinmerbean.AllCinemaBean;
import com.bw.movie.ui.cinema.interactor.allcinemamodel.AllCinemaFragmentInteractor;
import com.bw.movie.ui.cinema.interactor.allcinemamodel.IAllCinemaFragmentInteractor;
import com.bw.movie.ui.cinema.view.allcinmeaview.AllCinemaFragmentView;

/**
 * @author BySevenroup小小
 * @create 2018/9/3 20:33
 * @Description
 */
public class AllCinemaFragmentPresenter extends BasePresenter<AllCinemaFragmentView> implements IAllCinemaFragmentPresenter {

    private AllCinemaFragmentInteractor AllCinemaModel;

    public AllCinemaFragmentPresenter(AllCinemaFragmentView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        AllCinemaModel = new AllCinemaFragmentInteractor();

    }
    public  void getAllCinemaData(){
        AllCinemaModel.getAllCinemaData(new IAllCinemaFragmentInteractor() {
            @Override
            public void getAllCinemaSuc(AllCinemaBean allCinemaBean) {
                //接口回调
                view.getNearCinemaSuc(allCinemaBean);
            }

            @Override
            public void getAllCinemaErr(String errMsg) {
                view.getNearCinemaFail("错误");
            }
        });
    }
    @Override
    public void destriy() {
        super.onDestory();

    }

    @Override
    public Context getContext() {
        return null;
    }
}
