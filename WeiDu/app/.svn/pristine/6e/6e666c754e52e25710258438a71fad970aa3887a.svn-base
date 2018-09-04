package com.bw.movie.ui.cinema.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.ui.cinema.cinmerbean.AllCinemaBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author BySevenroup小小
 * @create 2018/9/3 20:54
 * @Description
 */
public class CinAllFrgRecyclerviewAdapter extends RecyclerView.Adapter<CinAllFrgRecyclerviewAdapter.AllHolder> {

    private Context context;
    private List<AllCinemaBean.ResultBean> AllCinemaBeans;

    public CinAllFrgRecyclerviewAdapter(Context context, List<AllCinemaBean.ResultBean> allCinemaBeans) {
        this.context = context;
        AllCinemaBeans = allCinemaBeans;
    }

    @NonNull
    @Override
    public AllHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.frg_cinema_all_item_layout, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layoutParams.setMargins(0, 0, 0, 20);
        inflate.setLayoutParams(layoutParams);
        return new AllHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull AllHolder holder, int position) {
        Glide.with(context).load(AllCinemaBeans.get(position).getLogo()).into(holder.NearCinemaTitleSimple);
        holder.NearCinemaTitleText.setText(AllCinemaBeans.get(position).getName());
        holder.NearCinemaAddressText.setText(AllCinemaBeans.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return AllCinemaBeans.size();
    }

    public class AllHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.NearCinema_title_simple)
        ImageView NearCinemaTitleSimple;
        @BindView(R.id.NearCinema_title_text)
        TextView NearCinemaTitleText;
        @BindView(R.id.NearCinema_address_text)
        TextView NearCinemaAddressText;
        public AllHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
