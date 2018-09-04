package com.bw.movie.ui.member.act_login.interactor;

import com.bw.movie.ui.member.act_login.bean.LoginBean;

/**
 * @author BySevenGroup_zwj
 * @create 2018/9/2 13:03
 * @Description
 */
public interface IUserLoginInteractor {
    void getLoginDataSuc(LoginBean loginBean);
    void getLoginDataFai(String errMsg);
}
