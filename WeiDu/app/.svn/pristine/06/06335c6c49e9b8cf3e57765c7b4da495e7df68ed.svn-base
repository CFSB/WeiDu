package com.bw.movie.ui.movie.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * @author BySevenGroup* Ice *
 * @create 2018/9/2 21:23
 * @Description
 */
public class MovieViewPagerAdapter extends FragmentPagerAdapter {
    private String[] titles = {"热门影片","正在上映","即将上映"};
    private List<Fragment> list;
    public MovieViewPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
