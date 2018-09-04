package com.bw.movie.ui.cinema.view.allcinmeaview;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.ui.cinema.adapter.CinAllFrgRecyclerviewAdapter;
import com.bw.movie.ui.cinema.cinmerbean.AllCinemaBean;
import com.bw.movie.ui.cinema.presenter.allcinemapresenter.AllCinemaFragmentPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author BySevenGroup
 * @create 2018/8/31 15:12
 * @Description
 */
public class AllCinemaFragment extends BaseFragment<AllCinemaFragmentPresenter> implements AllCinemaFragmentView {


    @BindView(R.id.cin_all_frg_recyclerview)
    RecyclerView cinAllFrgRecyclerview;
    @BindView(R.id.cin_all_frg_smert)
    SmartRefreshLayout cinAllFrgSmert;
    Unbinder unbinder;

    @Override
    protected AllCinemaFragmentPresenter getPresenter() {
        mPresenter = new AllCinemaFragmentPresenter(this);
        return mPresenter;
    }

    @Override
    protected void initView(View view) {
        //设置布局管理器
        cinAllFrgRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_all_cinema;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        //调用p层
        mPresenter.getAllCinemaData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getNearCinemaSuc(AllCinemaBean allCinemaBean) {//请求成功
        Log.i("uuu", allCinemaBean.getResult().get(0).getAddress());
        //设置适配器
        cinAllFrgRecyclerview.setAdapter(new CinAllFrgRecyclerviewAdapter(getActivity(),allCinemaBean.getResult()));
    }

    @Override
    public void getNearCinemaFail(String errMsg) {//请求失败

    }
}
