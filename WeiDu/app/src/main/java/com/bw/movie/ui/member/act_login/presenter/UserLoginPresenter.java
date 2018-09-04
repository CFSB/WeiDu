package com.bw.movie.ui.member.act_login.presenter;

import android.text.TextUtils;

import com.bw.movie.base.mvpbase.BasePresenter;
import com.bw.movie.ui.member.act_login.bean.LoginBean;
import com.bw.movie.ui.member.act_login.interactor.UserLoginInteractor;
import com.bw.movie.ui.member.act_login.view.IUserLoginView;
import com.bw.movie.base.InteractorCallBack;
import com.bw.movie.utils.RegexUtils;

/**
 * @author BySevenGroup_zwj
 * @create 2018/9/1 20:56
 * @Description
 */
public class UserLoginPresenter extends BasePresenter<IUserLoginView> {

    private UserLoginInteractor userLoginInteractor;

    public UserLoginPresenter(IUserLoginView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        userLoginInteractor = new UserLoginInteractor();
    }

    public void goToLogin(String mobile, String pwd) {
        if(TextUtils.isEmpty(mobile) && TextUtils.isEmpty(pwd)){//如果为空，返回
            view.getLoginDataFai(String.valueOf("用户名和密码不能为空"));
            return;
        } else if(RegexUtils.checkPwdLength(pwd)){
            view.getLoginDataFai(String.valueOf("密码不能少于6位，大于16位"));
            return;
        }else {
            userLoginInteractor.goToLogin(mobile, pwd, new InteractorCallBack <LoginBean>() {
                @Override
                public void getDataCallBackSuc(LoginBean bean) {
                    view.getLoginDataSuc(bean);
                }
                @Override
                public void getDataCallBackFai(String errMsg) {
                    view.getLoginDataFai(errMsg);
                }
            });
        }

    }

    @Override
    public void onDestory() {
        super.onDestory();
    }
}