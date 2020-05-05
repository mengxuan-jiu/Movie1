package com.bw.movie.mvp.view.adapter.cinema;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @包名 com.bw.myapplication.adapter
 * @MengXuanmengxuan
 * @日期2020/4/3
 * @项目名MyApplication6
 * @类名CinmaAdapter
 **/
public class CinmaAdapter extends RecyclerView.Adapter<CinmaAdapter.CinmaViewHolder> {


    @NonNull
    @Override
    public CinmaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CinmaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cmovie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CinmaViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
//头像
    public class CinmaViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdv)
        SimpleDraweeView sdv;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.tt)
        TextView tt;

        public CinmaViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
