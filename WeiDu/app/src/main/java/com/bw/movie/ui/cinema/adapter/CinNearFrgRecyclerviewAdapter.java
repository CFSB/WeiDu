package com.bw.movie.ui.cinema.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.ui.cinema.cinmerbean.NearCinemaBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.math.BigDecimal;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * @author BySevenroup小小
 * @create 2018/9/2 20:53
 * @Description
 */
public class CinNearFrgRecyclerviewAdapter extends RecyclerView.Adapter<CinNearFrgRecyclerviewAdapter.NearCinemaHolder> {

    private Context context;
    private List<NearCinemaBean.ResultBean.NearbyCinemaListBean> nearbyCinemaListBeans;

    public CinNearFrgRecyclerviewAdapter(Context context, List<NearCinemaBean.ResultBean.NearbyCinemaListBean> nearbyCinemaListBeans) {
        this.context = context;
        this.nearbyCinemaListBeans = nearbyCinemaListBeans;
    }

    @NonNull
    @Override
    public NearCinemaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.frg_cinema_near_item_layout, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layoutParams.setMargins(0,0,0,20);
        inflate.setLayoutParams(layoutParams);
        return new NearCinemaHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NearCinemaHolder holder, int position) {
        Glide.with(context).load(nearbyCinemaListBeans.get(position).getLogo()).into(holder.NearCinemaTitleSimple);
        holder.NearCinemaTitleText.setText(nearbyCinemaListBeans.get(position).getName());
        holder.NearCinemaAddressText.setText(nearbyCinemaListBeans.get(position).getAddress());
        String distance = nearbyCinemaListBeans.get(position).getDistance();
        double v = Double.parseDouble(distance);
        double b = v / 1000;
        holder.NearCinemaDistanceText.setText(String.valueOf(String.format("%.1f",b)+"km"));
    }

    @Override
    public int getItemCount() {
        return nearbyCinemaListBeans.size();
    }

    public class NearCinemaHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.NearCinema_title_simple)
        ImageView NearCinemaTitleSimple;
        @BindView(R.id.NearCinema_title_text)
        TextView NearCinemaTitleText;
        @BindView(R.id.NearCinema_address_text)
        TextView NearCinemaAddressText;
        @BindView(R.id.NearCinema_distance_text)
        TextView NearCinemaDistanceText;
        public NearCinemaHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
