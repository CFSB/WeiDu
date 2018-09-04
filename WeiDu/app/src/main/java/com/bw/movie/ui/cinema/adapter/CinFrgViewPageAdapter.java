package com.bw.movie.ui.cinema.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * @author BySevenroup小小
 * @create 2018/9/1 16:01
 * @Description
 */
public class CinFrgViewPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    String strtitle[]={"附近影院","全部影院"};
    public CinFrgViewPageAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public CinFrgViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragmentList.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strtitle[position];
    }
}
