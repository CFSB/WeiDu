package com.bw.movie.ui.member.act_follow_cinema.view;

import com.bw.movie.base.mvpbase.IView;
import com.bw.movie.ui.member.act_follow_cinema.bean.FollowCinemaBean;

/**
 * @author BySevenGroup_zwj
 * @create 2018/9/1 18:00
 * @Description
 */
public interface IFollowCinemaView extends IView {

    void getFollowCinemaDataSuccess(FollowCinemaBean followCinemaBean);

    void getFollowCinemaDataFailed(String errMsg);
}
