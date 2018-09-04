package com.bw.movie.ui.member;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.mvpbase.BasePresenter;
import com.bw.movie.ui.member.act_login.view.UserLoginActivity;
import com.bw.movie.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MemberFragment extends BaseFragment {


    @BindView(R.id.genernal_tool_bar_title)
    TextView genernalToolBarTitle;
    Unbinder unbinder;
    @BindView(R.id.frg_member_userIcon)
    SimpleDraweeView frgMemberUserIcon;
    @BindView(R.id.frg_member_nickName)
    TextView frgMemberNickName;
    @BindView(R.id.frg_member_wx_login)
    ImageView frgMemberWxLogin;

    @Override
    protected void initView(View view) {
        //initToolbar
        initToolbar(R.id.frg_member_toolBar);
        genernalToolBarTitle.setText(R.string.top_page_member_title);
        //
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_member;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.frg_member_userIcon, R.id.frg_member_nickName, R.id.frg_member_wx_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /**
             * 这两个图标无论点谁都执行第二个
             * 先判断是否登录
             *      1登录，跳到个人信息界面
             *      2未登录，跳到登录界面(和前面几个登录页面通用)
             *  ps  未登录时微信小图标显示
             *      登录后微信小图标隐藏
             */
            case R.id.frg_member_userIcon:
            case R.id.frg_member_nickName:
                if (true) {//模拟未登录，跳到登录界面
                    openActivity(UserLoginActivity.class,null);
                }
                break;
            case R.id.frg_member_wx_login:
                ToastUtils.showShort(getActivity(),"尚未开发");
                break;
        }
    }
}
