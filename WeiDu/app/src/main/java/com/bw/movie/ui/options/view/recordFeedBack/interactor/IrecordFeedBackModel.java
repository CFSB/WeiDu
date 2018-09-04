package com.bw.movie.ui.options.view.recordFeedBack.interactor;

import com.bw.movie.bean.FeedBookBean;
import com.bw.movie.base.InteractorCallBack;


/**
 * @author BySevenGroup苗宇鸿
 * @create 2018/9/2 20:43
 * @Description
 */
public interface IrecordFeedBackModel{
    void getrecordFeedBack(int userId, String sessionId, String content, InteractorCallBack <FeedBookBean> callBack);
}
