package com.bw.movie.ui.movie;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.mvpbase.BasePresenter;
import com.bw.movie.ui.movie.adapter.MovieViewPagerAdapter;
import com.bw.movie.ui.movie.fragment.Movie_Hot;
import com.bw.movie.ui.movie.fragment.Movie_now;
import com.bw.movie.ui.movie.fragment.Movie_quick;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author BySevenGroup
 * @create 2018/8/31 15:12
 * @Description
 */
public class MovieFragment extends BaseFragment {


    @BindView(R.id.genernal_tool_bar_title)
    TextView genernalToolBarTitle;
    private List<Fragment> list = new ArrayList<>();
    Unbinder unbinder1;
    private TabLayout frg_movie_tablayout;
    private ViewPager frg_movie_viewpager;


    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        //initToolbar
        initToolbar(R.id.frg_movie_toolBar);
        genernalToolBarTitle.setText(R.string.top_page_movie_title);
        frg_movie_tablayout = view.findViewById(R.id.frg_movie_tablayout);
        frg_movie_viewpager = view.findViewById(R.id.frg_movie_viewpager);
    }


    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        list.add(new Movie_Hot());
        list.add(new Movie_now());
        list.add(new Movie_quick());
        frg_movie_tablayout.setTabTextColors(Color.BLACK,Color.RED);
        frg_movie_viewpager.setAdapter(new MovieViewPagerAdapter(getActivity().getSupportFragmentManager(),list));
        frg_movie_tablayout.setupWithViewPager(frg_movie_viewpager);
    }
}
