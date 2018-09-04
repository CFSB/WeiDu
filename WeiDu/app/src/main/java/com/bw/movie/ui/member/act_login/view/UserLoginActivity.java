package com.bw.movie.ui.member.act_login.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.ui.member.act_login.bean.LoginBean;
import com.bw.movie.ui.member.act_login.presenter.UserLoginPresenter;
import com.bw.movie.ui.member.act_reg.RegActivity;
import com.bw.movie.utils.SharedPreferencesUtils;
import com.bw.movie.utils.ToastUtils;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author BySevenGroup_zwj
 * @create 2018/9/1 20:25
 * @Description
 */
public class UserLoginActivity extends BaseActivity <UserLoginPresenter> implements IUserLoginView {

    @BindView(R.id.genernal_tool_bar_title)
    TextView genernalToolBarTitle;//页面标题
    @BindView(R.id.act_user_login_inputMobile)
    EditText inputMobile;//用户输入的手机号
    @BindView(R.id.act_user_login_inputPwd)
    EditText inputPwd;//密码
    @BindView(R.id.act_user_login_pwdVisibility)
    ImageView imgPwdVisibility;//显示隐藏秘密
    @BindView(R.id.act_user_login_btn)
    Button loginBtn;//登录按钮
    @BindView(R.id.act_user_login_clear_text)
    ImageView actUserLoginClearText;//清除密码输入框内容的close图片
    @BindView(R.id.act_user_login_qqLogin)
    ImageView actUserLoginQqLogin;//qq登录
    @BindView(R.id.act_user_login_wxLogin)
    ImageView actUserLoginWxLogin;//wx登录

    private Unbinder unbinder;
    //用来判断是否显示或隐藏密码
    private boolean pwdFlag = false;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_user_login;
    }

    @Override
    protected void initListener() {
        SetInputPwdTextChange();
    }



    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initToolBar();
    }

    private void initToolBar() {
        initToolbar(R.id.act_user_login_toolBar);
        genernalToolBarTitle.setText(R.string.top_page_userLogin_title);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.img_finish_page_white);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected UserLoginPresenter getPresenter() {
        return presenter != null ? presenter : (presenter = new UserLoginPresenter(this));
    }

    @OnClick({R.id.act_user_login_pwdVisibility, R.id.act_user_login_btn, R.id.act_user_login_goToReg, R.id.act_user_login_qqLogin, R.id.act_user_login_wxLogin,R.id.act_user_login_clear_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.act_user_login_pwdVisibility://显示隐藏密码
                if (pwdFlag == false) {
                    inputPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imgPwdVisibility.setImageResource(R.drawable.visibility_open);
                    pwdFlag = true;
                } else {
                    inputPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imgPwdVisibility.setImageResource(R.drawable.visibility_off);
                    pwdFlag = false;
                }
                break;
            case R.id.act_user_login_btn://点击登录按钮
                goToLogin(inputMobile.getText().toString().trim(), inputPwd.getText().toString().trim());
                break;
            case R.id.act_user_login_goToReg://去注册
                openActivity(RegActivity.class, null);
                break;
            case R.id.act_user_login_qqLogin://qq登录
            case R.id.act_user_login_wxLogin://微信登录
                ToastUtils.showShort(this, "Wait A Minute~,程序员在开发");
                break;
            case R.id.act_user_login_clear_text://清除用户输入的密码
                if (!TextUtils.isEmpty(inputPwd.getText()))
                    inputPwd.getText().clear();
                break;
        }
    }

    private void goToLogin(String mobile, String pwd) {
        presenter.goToLogin(mobile, pwd);
        //Log.i("aaa","解密的密码"+EncryptUtil.decrypt("uov5L6x0HQzUQ7tkRkE3hg=="));
    }

    @Override
    public void getLoginDataSuc(LoginBean loginBean) {//请求成功回调
        Gson gson = new Gson();
        String json = gson.toJson(loginBean);
        SharedPreferencesUtils.putString(SharedPreferencesUtils.UserInfoFileName, SharedPreferencesUtils.UserInfoKey, json);

        String string = SharedPreferencesUtils.getString(SharedPreferencesUtils.UserInfoFileName, SharedPreferencesUtils.UserInfoKey, "");
        //登录成功，用户信息保存，下次自动登录
        ToastUtils.showShort(this, loginBean.getMessage());
    }

    @Override
    public void getLoginDataFai(String errMsg) {//请求失败回调
        ToastUtils.showShort(this, errMsg);
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    protected void onDestroy() {
        if (presenter != null)
            presenter.onDestory();
        if (unbinder != null) {
            unbinder = null;
        }
        super.onDestroy();
    }
    private void SetInputPwdTextChange() {
        inputPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 1) {
                    actUserLoginClearText.setVisibility(View.VISIBLE);
                }else {
                    actUserLoginClearText.setVisibility(View.GONE);
                }
                if (editable.length() >= 6) {
                    loginBtn.setEnabled(true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        loginBtn.setBackground(getResources().getDrawable(R.drawable.login_btn_enable_bg));
                    }
                } else {
                    loginBtn.setEnabled(false);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        loginBtn.setBackground(getResources().getDrawable(R.drawable.general_btn_radius));
                    }
                }
            }
        });
    }
}
