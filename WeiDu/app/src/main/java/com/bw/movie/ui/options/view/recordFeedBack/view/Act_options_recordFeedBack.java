package com.bw.movie.ui.options.view.recordFeedBack.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.mvpbase.IView;
import com.bw.movie.bean.FeedBookBean;
import com.bw.movie.ui.options.view.recordFeedBack.presenter.RecordFeedBackPresenterimpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Act_options_recordFeedBack extends BaseActivity<RecordFeedBackPresenterimpl> implements IView, IViewrecordFeedBack {


    private static final String TAG = "Act_options_recordFeedB";
    @BindView(R.id.genernal_tool_bar_title)
    TextView genernalToolBarTitle;
    @BindView(R.id.record_feed_back_name)
    EditText recordFeedBackName;
    @BindView(R.id.record_feed_back_submit)
    Button recordFeedBackSubmit;
    @BindView(R.id.record_feed_back_back)
    ImageView recordFeedBackBack;
    private Unbinder bind;

    @Override
    protected RecordFeedBackPresenterimpl getPresenter() {
        presenter = new RecordFeedBackPresenterimpl(this);
        return presenter;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_act_main_record_feed_back;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    //初始化空间
    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
        //        为title设值
        genernalToolBarTitle.setText(R.string.suggestion_feedback);

    }

    @Override
    public Context getContext() {
        return this;
    }

    //意见反馈成功返回
    @Override
    public void getrecordFeedBack(FeedBookBean bean) {
        Toast.makeText(this,bean.getMessage(),Toast.LENGTH_SHORT).show();
        Log.d(TAG, "getrecordFeedBack: " + bean.getMessage());
        if (bean.getMessage().equals("反馈成功")){
            finish();
        }
    }

    //错误返回
    @Override
    public void error(String error) {
        Log.d(TAG, "error: " + error);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.record_feed_back_back, R.id.record_feed_back_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.record_feed_back_back:
                //点击back返回销毁当前页面
                finish();
                break;
            case R.id.record_feed_back_submit:
                String name = recordFeedBackName.getText().toString();
                //判断反馈值是否为空
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(this, "反馈内容不能为空！！！", Toast.LENGTH_SHORT).show();
                } else {
                    //发出请求
                    presenter.getrecordFeedBack(315, "1535955466077315", name);
                }
                break;
        }
    }
}
