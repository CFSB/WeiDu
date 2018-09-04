package com.bw.movie.ui.options.view.presenterMessage;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;

import com.facebook.drawee.view.SimpleDraweeView;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Presenter_MessageActivity extends AppCompatActivity {

    @BindView(R.id.genernal_tool_bar_title)
    TextView genernalToolBarTitle;
    @BindView(R.id.presenter_message_back)
    ImageView presenterMessageBack;
    @BindView(R.id.head_portrait_simple)
    SimpleDraweeView headPortraitSimple;
    @BindView(R.id.nickname_text)
    TextView nicknameText;
    @BindView(R.id.region_text)
    TextView regionText;
    @BindView(R.id.email_text)
    TextView emailText;
    @BindView(R.id.gender_text)
    TextView genderText;
    @BindView(R.id.Last_login_time_text)
    TextView LastLoginTimeText;
    @BindView(R.id.person_message)
    RelativeLayout personMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presenter__message);
        ButterKnife.bind(this);
//        SharedPreferences user = getSharedPreferences("userInfo", MODE_WORLD_READABLE);
        String head_picture = "http://172.17.8.100/images/movie/head_pic/2018-08-30/20180830210326.png";
        String sessionId = "1535974746930315";
        int userId = 315;

        long lastLoginTime =1535955466;
        headPortraitSimple.setImageURI(Uri.parse(head_picture));
        nicknameText.setText("苗宇鸿");
        regionText.setText("北京");
        emailText.setText("364746003@qq.com");
        genderText.setText("男");
        //转化时间
        Date date = new Date(lastLoginTime);
        Log.d("www", "onCreate: "+date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);

        //设置时间
        LastLoginTimeText.setText(dateString);

        genernalToolBarTitle.setText(R.string.person_message);
        presenterMessageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        }
}
