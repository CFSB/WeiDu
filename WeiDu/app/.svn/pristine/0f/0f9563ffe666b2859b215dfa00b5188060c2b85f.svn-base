package com.bw.movie.ui.options.view.recordFeedBack.presenter;

import com.bw.movie.base.mvpbase.BasePresenter;
import com.bw.movie.bean.FeedBookBean;
import com.bw.movie.ui.options.view.recordFeedBack.interactor.IrecordFeedBackModel;
import com.bw.movie.ui.options.view.recordFeedBack.interactor.RecordFeedBackimpl;
import com.bw.movie.ui.options.view.recordFeedBack.view.Act_options_recordFeedBack;
import com.bw.movie.base.InteractorCallBack;

/**
 * @author BySevenGroup苗宇鸿
 * @create 2018/9/2 20:57
 * @Description
 */
public class RecordFeedBackPresenterimpl extends BasePresenter<Act_options_recordFeedBack> implements IRecordFeedBackPresenter{

    private IrecordFeedBackModel model;

    public RecordFeedBackPresenterimpl(Act_options_recordFeedBack view) {
        super(view);
    }

    @Override
    public void getrecordFeedBack(int userId, String sessionId, String content) {
        model.getrecordFeedBack(userId,sessionId,content, new InteractorCallBack<FeedBookBean>() {
            @Override
            public void getDataCallBackSuc(FeedBookBean bean) {
                view.getrecordFeedBack(bean);
            }

            @Override
            public void getDataCallBackFai(String error) {
                view.error(error);
            }
        });
    }

    @Override
    protected void initModel() {
        model = new RecordFeedBackimpl();
    }
}
