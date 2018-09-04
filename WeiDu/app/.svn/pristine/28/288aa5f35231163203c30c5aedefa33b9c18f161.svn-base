package com.bw.movie.ui.cinema.view.nearcinemaview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.ui.cinema.adapter.CinNearFrgRecyclerviewAdapter;
import com.bw.movie.ui.cinema.cinmerbean.NearCinemaBean;
import com.bw.movie.ui.cinema.presenter.nearcinemapresenter.NearCinemaPresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author BySevenGroup
 * @create 2018/8/31 15:12
 * @Description
 */
public class NearCinemaFragment extends  BaseFragment<NearCinemaPresenter> implements INearCinemaFragmentView {


    @BindView(R.id.cin_near_frg_recyclerview)
    RecyclerView cinNearFrgRecyclerview;
    @BindView(R.id.cin_near_frg_smert)
    SmartRefreshLayout cinNearFrgSmert;
    Unbinder unbinder;
    private String page = "1";
    private String count = "10";


    @Override
    protected void initView(View view) {
        //设置recyview布局管理器
        cinNearFrgRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_near_cinema;
    }

    @Override
    protected void initListener() {
        //smart刷新

    }

    @Override
    protected void initData() {
        Fresco.initialize(getActivity());
        //调用p层
        mPresenter.getNearData(page,count);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected NearCinemaPresenter getPresenter() {
        //实例化P层
        mPresenter = new NearCinemaPresenter(this);

        return mPresenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getNearCinemaSuc(NearCinemaBean nearCinemaBean) {//请求成功方法
        Log.i("fff", nearCinemaBean.getResult().getNearbyCinemaList().get(0).getAddress());
        //设置适配器
        cinNearFrgRecyclerview.setAdapter(new CinNearFrgRecyclerviewAdapter(getActivity(),nearCinemaBean.getResult().getNearbyCinemaList()));
    }

    @Override
    public void getNearCinemaFail(String errMsg) {

    }
}
