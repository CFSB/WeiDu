package com.bw.movie.ui.cinema.presenter.nearcinemapresenter;

import com.bw.movie.base.mvpbase.BasePresenter;
import com.bw.movie.ui.cinema.cinmerbean.NearCinemaBean;
import com.bw.movie.ui.cinema.interactor.nearmodel.INearCinemaFragmentInteractor;
import com.bw.movie.ui.cinema.interactor.nearmodel.NearCinemaFragmentInteractor;
import com.bw.movie.ui.cinema.view.nearcinemaview.INearCinemaFragmentView;

/**
 * @author BySevenGroup
 * @create 2018/8/31 15:12
 * @Description
 */
public class NearCinemaPresenter extends BasePresenter<INearCinemaFragmentView> implements ICinmaFragmentPresenter {


    private NearCinemaFragmentInteractor nearCinmaModel;

    public NearCinemaPresenter(INearCinemaFragmentView view) {
        super(view);
    }


    public  void getNearData(String page,String count){
        nearCinmaModel.getNearCinemaData(new INearCinemaFragmentInteractor() {
            @Override
            public void getNearCinemaSuc(NearCinemaBean nearCinemaBean) {
                //接口回调
                view.getNearCinemaSuc(nearCinemaBean);
            }

            @Override
            public void getNearCinemaFail(String errMsg) {

            }
        },page,count);
    }
    @Override
    public void destroy() {
        super.onDestory();
    }

    @Override
    protected void initModel() {
        nearCinmaModel = new NearCinemaFragmentInteractor();
    }
}
