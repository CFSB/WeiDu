package com.bw.movie.ui.options.view;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.mvpbase.BasePresenter;
import com.bw.movie.ui.options.view.presenterMessage.Presenter_MessageActivity;
import com.bw.movie.ui.options.view.recordFeedBack.view.Act_options_recordFeedBack;
import com.bw.movie.ui.options.view.updatePwd.UpdatePwdActivity;
import com.bw.movie.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class OptionsFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.genernal_tool_bar_title)
    TextView genernalToolBarTitle;
    @BindView(R.id.person_message)
    RelativeLayout personMessage;
    @BindView(R.id.update_password)
    RelativeLayout updatePassword;
    @BindView(R.id.automatic_login)
    RelativeLayout automaticLogin;
    @BindView(R.id.clear_cache)
    RelativeLayout clearCache;
    @BindView(R.id.software_upgrading)
    RelativeLayout softwareUpgrading;
    @BindView(R.id.suggestion_feedback)
    RelativeLayout suggestionFeedback;
    @BindView(R.id.About_the_dimension)
    RelativeLayout AboutTheDimension;
    @BindView(R.id.Service_tel)
    RelativeLayout ServiceTel;
    @BindView(R.id.log_out)
    TextView logOut;
    @BindView(R.id.Switching_night_mode)
    RelativeLayout SwitchingNightMode;
    @BindView(R.id.Switching_night_mode_switchButton)
    SwitchButton SwitchingNightModeSwitchButton;
    @BindView(R.id.auto_login_switchButton)
    SwitchButton autoLoginSwitchButton;

    @Override
    protected void initView(View view) {
        //initToolbar
        initToolbar(R.id.frg_options_toolBar);
        genernalToolBarTitle.setText(R.string.top_page_options_title);
        String string = SharedPreferencesUtils.getString(SharedPreferencesUtils.UserInfoFileName, SharedPreferencesUtils.UserInfoKey, "");
        //判断是否登录
        //判断是否显示退出登录按钮
        if (string.equals("")) {
            logOut.setVisibility(View.GONE);
        } else {
            logOut.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    protected int provideLayoutId() {
        return R.layout.fragment_options;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder != null)
            unbinder.unbind();
    }


    @OnClick({R.id.person_message, R.id.Switching_night_mode, R.id.update_password, R.id.automatic_login, R.id.clear_cache, R.id.software_upgrading, R.id.suggestion_feedback, R.id.About_the_dimension, R.id.Service_tel, R.id.log_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.person_message:
                startActivity(new Intent(getContext(), Presenter_MessageActivity.class));
                Toast.makeText(getContext(), "个人信息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.update_password:
                startActivity(new Intent(getContext(), UpdatePwdActivity.class));
                break;
            case R.id.Switching_night_mode:
                SwitchingNightModeSwitchButton.setToggleOff();
                Toast.makeText(getContext(), "切换夜间模式", Toast.LENGTH_SHORT).show();
                //判断切换白天还是夜间
                //                int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                //                if (mode == Configuration.UI_MODE_NIGHT_YES) {
                //                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                //                } else if (mode == Configuration.UI_MODE_NIGHT_NO) {
                //                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                //                }
                //                getActivity().recreate();

                break;
            case R.id.automatic_login:
                Toast.makeText(getContext(), "自动登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clear_cache:
                //                清楚缓存
                getClearCache();
                break;
            case R.id.software_upgrading:
                Toast.makeText(getContext(), "软件更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.suggestion_feedback:
                Toast.makeText(getContext(), "反馈更新", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), Act_options_recordFeedBack.class));
                break;
            case R.id.About_the_dimension:
                Toast.makeText(getContext(), "关于应用", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Service_tel:
                Toast.makeText(getContext(), "服务电话", Toast.LENGTH_SHORT).show();
                break;
            case R.id.log_out:
                Toast.makeText(getContext(), "退出登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //清楚缓存
    private void getClearCache() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("清空缓存")
                .setMessage("清除缓存会导致下载的内容删除，是否确定?")
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // TODO: 2018/9/3 进行删除操作
                        Toast.makeText(getContext(), "缓存已经清楚", Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
