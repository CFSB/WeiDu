package com.bw.movie.ui.cinema.view;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.ui.cinema.adapter.CinFrgViewPageAdapter;
import com.bw.movie.ui.cinema.presenter.nearcinemapresenter.NearCinemaPresenter;
import com.bw.movie.ui.cinema.view.allcinmeaview.AllCinemaFragment;
import com.bw.movie.ui.cinema.view.nearcinemaview.NearCinemaFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author BySevenGroup小小
 * @create 2018/8/31 15:12
 * @Description本模块主要展示附近影院以及全部影院两大模块 点击子条目并且可以进行详情展示
 * 本Model命名规范:cin_frg_
 */
public class CinemaFragment extends BaseFragment {


    @BindView(R.id.cin_frg_tab)
    TabLayout cinFrgTab;
    @BindView(R.id.cin_frg_viewpage)
    ViewPager cinFrgViewpage;
    Unbinder unbinder;
    @BindView(R.id.cin_frg_locition_img)
    ImageView cinFrgLocitionImg;
    private List<Fragment> fragmentList;


    @Override
    protected void initView(View view) {//初始化view

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected void initListener() {
        //点击定位进入map显示
        cinFrgLocitionImgSetOnclick();

    }

    private void cinFrgLocitionImgSetOnclick() {
        cinFrgLocitionImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(MapActivity.class,null);
            }
        });
    }

    @Override
    protected void initData() {//初始化数据
        //把fragment加入到集合用于viewpage的切换
        AddFragment();
        //设置viewpage适配器
        cinFrgViewpage.setAdapter(new CinFrgViewPageAdapter(getFragmentManager(), fragmentList));
        //将viewpage与tablayout联动起来
        cinFrgTab.setupWithViewPager(cinFrgViewpage);
    }

    private void AddFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new NearCinemaFragment());
        fragmentList.add(new AllCinemaFragment());
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
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
