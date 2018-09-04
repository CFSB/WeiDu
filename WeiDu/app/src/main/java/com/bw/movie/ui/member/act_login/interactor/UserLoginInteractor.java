package com.bw.movie.ui.member.act_login.interactor;

import com.bw.movie.ui.member.act_login.bean.LoginBean;
import com.bw.movie.utils.EncryptUtil;
import com.bw.movie.base.InteractorCallBack;
import com.bw.movie.utils.RetrofitClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author BySevenGroup_zwj
 * @create 2018/9/2 12:42
 * @Description
 */
public class UserLoginInteractor {

    public void goToLogin(String mobile, String pwd, final InteractorCallBack<LoginBean> listener) {
        Observable <LoginBean> loginBeanObservable = RetrofitClient.getInstance().getCommonApi().getloginData(mobile, EncryptUtil.encrypt(pwd));
        loginBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber <LoginBean>() {
                    @Override
                    public void onCompleted() {}
                    @Override
                    public void onError(Throwable e) {
                        listener.getDataCallBackFai(e.getMessage());
                    }
                    @Override
                    public void onNext(LoginBean loginBean) {
                        listener.getDataCallBackSuc(loginBean);
                    }
                });
    }
}