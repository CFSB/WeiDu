package com.bw.movie.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.base.mvpbase.BasePresenter;
import com.bw.movie.base.mvpbase.BaseView;
import com.bw.movie.utils.ToastUtils;

import butterknife.ButterKnife;

/**
 * @author BySevenGroup
 * @create 2018/8/31 15:12
 * @Description
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    protected P mPresenter;
    Activity mActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(provideLayoutId(), container, false);
        ButterKnife.bind(this,view);
        mActivity = getActivity();
        mPresenter = getPresenter();
        initView(view);
        return view;
    }

    public Toolbar initToolbar(int toolbarId) {
        AppCompatActivity mAppCompatActivity = (AppCompatActivity) mActivity;
        Toolbar toolbar = mAppCompatActivity.findViewById(toolbarId);
        mAppCompatActivity.setSupportActionBar(toolbar);
        ActionBar actionBar = mAppCompatActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        return toolbar;
    }

    //获取实例化presenter
    protected abstract P getPresenter();

    /**
     *  唯一在onCreateView中初始化的方法
     *  初始化视图(布局)
     */
    protected abstract void initView(View view);

    //获取布局
    protected abstract int provideLayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initListener();
    }
    //监听
    protected abstract void initListener();

    protected abstract void initData();
    //销毁
    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestory();
        }
        super.onDestroy();
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showShort(getActivity(),msg);
    }

    /**
     * 意图对象跳转
     * @param targetActivityClass
     * @param bundle
     */
    public void openActivity(Class<?> targetActivityClass, Bundle bundle) {
        Intent intent = new Intent(mActivity, targetActivityClass);

        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

}
