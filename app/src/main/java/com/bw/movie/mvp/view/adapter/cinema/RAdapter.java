package com.bw.movie.mvp.view.adapter.cinema;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.cinema.FindCinemaByRegion;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @包名 com.bw.myapplication.adapter
 * @MengXuanmengxuan
 * @日期2020/4/3
 * @项目名MyApplication6
 * @类名CinmaAdapter
 **/
public class RAdapter extends RecyclerView.Adapter<RAdapter.CinmaViewHolder> {


    private List<FindCinemaByRegion.ResultBean> list;

    public RAdapter(List<FindCinemaByRegion.ResultBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public CinmaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CinmaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.moves, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CinmaViewHolder holder, int position) {
        FindCinemaByRegion.ResultBean bean = list.get(position);
        String name = bean.getName();
        holder.text.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = bean.getId();
                onCheck.grtId(id);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //头像
    public class CinmaViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView text;
        public CinmaViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    onCheck onCheck;

    public void setOnCheck(RAdapter.onCheck onCheck) {
        this.onCheck = onCheck;
    }

    public interface onCheck{
        void grtId(int id);
}
}
