package com.bw.movie.mvp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.band.FindHotMovieBead;
import com.bw.movie.band.FindReleaseMovieBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author mengxuan
 * @包名 com.bw.movie.mvp.view.adapter
 * @MengXuanmengxuan
 * @日期2020/4/19
 * @项目名Movie
 * @类名AdapterFindHotMovie
 **/
public class AdapterFindHotMovie extends RecyclerView.Adapter<AdapterFindHotMovie.ViewHolderFindHotMovie> {
    private List<FindHotMovieBead.ResultBean> list;

    public AdapterFindHotMovie(List<FindHotMovieBead.ResultBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderFindHotMovie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderFindHotMovie(LayoutInflater.from(parent.getContext()).inflate(R.layout.find_hot_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFindHotMovie holder, int position) {
        FindHotMovieBead.ResultBean bean = list.get(position);
        String name = bean.getName();
        double score = bean.getScore();
        String imageUrl = bean.getImageUrl();
        Glide.with(holder.itemView)
                .load(imageUrl)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.encodeQualityOf(20))
                .into(holder.hImage);
        holder.hName.setText(name);
        holder.hScore.setText(score+"");

holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        onitimClickListener.getid(bean.getMovieId());
    }
});

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderFindHotMovie extends RecyclerView.ViewHolder {
        @BindView(R.id.h_image)
        ImageView hImage;
        @BindView(R.id.h_score)
        TextView hScore;
        @BindView(R.id.h_name)
        TextView hName;
        @BindView(R.id.butt_ticket_purchase)
        Button buttTicketPurchase;
        public ViewHolderFindHotMovie(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnitimClickListener(AdapterFindHotMovie.onitimClickListener onitimClickListener) {
        this.onitimClickListener = onitimClickListener;
    }

    onitimClickListener onitimClickListener;
    public interface  onitimClickListener{
        void getid(int  id);
    }
}
