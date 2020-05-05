package com.bw.movie.mvp.view.adapter.movie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.movieb.FindHot;
import com.bw.movie.util.FrescoUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @包名 com.bw.movie.view.adapter.movie
 * @MengXuanmengxuan
 * @日期2020/3/25
 * @项目名MyMovie
 * @类名FrfAdaqter
 **/
public class HtoAdaqter extends RecyclerView.Adapter<HtoAdaqter.FrfViewHolder> {


    private List<FindHot.ResultBean> list;

    public HtoAdaqter(List<FindHot.ResultBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public FrfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FrfViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.linearhot, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FrfViewHolder holder, int position) {
        FindHot.ResultBean bean = list.get(position);
        FrescoUtil.getInstance().myFillet(bean.getImageUrl(), holder.fSdv);
        holder.director.setText("导演:" + bean.getDirector());
        holder.movieName.setText(bean.getName());
        holder.play.setText("主演:" + bean.getStarring());
        holder.score.setText("评分:" + bean.getScore());
        holder.tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int movieId = bean.getMovieId();
                onItimClickListener.getMovieId(movieId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FrfViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.f_sdv)
        SimpleDraweeView fSdv;
        @BindView(R.id.movie_name)
        TextView movieName;
        @BindView(R.id.director)
        TextView director;
        @BindView(R.id.play)
        TextView play;
        @BindView(R.id.score)
        TextView score;
        @BindView(R.id.tickets)
        Button tickets;

        public FrfViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnItimClickListener onItimClickListener;

    public void setOnItimClickListener(OnItimClickListener onItimClickListener) {
        this.onItimClickListener = onItimClickListener;
    }

    public interface OnItimClickListener {
        void getMovieId(int id);
    }

}
