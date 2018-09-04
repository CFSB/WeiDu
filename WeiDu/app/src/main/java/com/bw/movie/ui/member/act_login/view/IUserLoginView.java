package com.bw.movie.ui.member.act_login.view;

import com.bw.movie.base.mvpbase.IView;
import com.bw.movie.ui.member.act_login.bean.LoginBean;

/**
 * @author BySevenGroup_zwj
 * @create 2018/9/1 20:26
 * @Description
 */
public interface IUserLoginView extends IView {

    void getLoginDataSuc(LoginBean loginBean);

    void getLoginDataFai(String errMsg);
}
