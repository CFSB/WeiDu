package com.bw.movie.ui.movie.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.bean.MovieListBean;
import com.bw.movie.ui.movie.fragment.Movie_Hot;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * @author BySevenGroup* Ice *
 * @create 2018/9/3 18:59
 * @Description
 */
public class MyPagerAdapter extends PagerAdapter{
    private Context mContext;
    private MovieListBean data;
    private CallBack callBack;


    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public MyPagerAdapter(MovieListBean data, Context context){
        this.data = data;
        mContext = context;
    }

    @Override
    public int getCount() {
        return data.getResult().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.frag_movie_item_main,container,false);
        //View view1 = LayoutInflater.from(mContext).inflate(R.layout.fragment_movie__hot,container,false);
        SimpleDraweeView imageView = (SimpleDraweeView) view.findViewById(R.id.frg_movie_iv);
        imageView.setImageURI(data.getResult().get(position).getImageUrl());
        Log.i("------------------",position+"");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onClick(data.getResult().get(position).getId());
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public interface CallBack{
        void onClick(Integer id);
    }
}
