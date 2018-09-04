package com.bw.movie.ui.options.view.recordFeedBack.interactor;

import com.bw.movie.bean.FeedBookBean;
import com.bw.movie.base.InteractorCallBack;
import com.bw.movie.utils.RetrofitClient;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author BySevenGroup苗宇鸿
 * @create 2018/9/2 20:44
 * @Description
 */
public class RecordFeedBackimpl implements IrecordFeedBackModel{

    @Override
    public void getrecordFeedBack(int userId, String sessionId, String content, final InteractorCallBack<FeedBookBean> callBack) {
        RetrofitClient.getInstance().getCommonApi().getrecordFeedBack(userId, sessionId, content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FeedBookBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.getDataCallBackFai(e.getMessage());

                    }

                    @Override
                    public void onNext(FeedBookBean feedBookBean) {
                        callBack.getDataCallBackSuc(feedBookBean);
                    }
                });
    }


}
