package com.bw.movie.mvp.view.adapter.cinema;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.cinema.FindCinemaInfo;

/**
 * @包名 com.bw.movie.view.adapter.cinema
 * @MengXuanmengxuan
 * @日期2020/4/9
 * @项目名MyMovie
 * @类名FindCinemaInfoAdapter
 **/
public class FindCinemaInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private FindCinemaInfo fRecommend;

    public FindCinemaInfoAdapter(FindCinemaInfo recommend) {

        fRecommend = recommend;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FindCinemaInfoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ll,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class FindCinemaInfoViewHolder extends RecyclerView.ViewHolder{

        public FindCinemaInfoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
