package com.bw.movie.mvp.view.adapter.cinema;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.cinema.Recommend;
import com.bw.movie.util.FrescoUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @包名 com.bw.movie.view.adapter.c
 * @MengXuanmengxuan
 * @日期2020/3/26
 * @项目名MyMovie
 * @类名RecommendAdapter
 **/
public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder> {
    private List<Recommend.ResultBean> fList;

    public RecommendAdapter(List<Recommend.ResultBean> list) {

        fList = list;
    }

    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecommendViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend, parent, false));
        //return new RecommendViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendViewHolder holder, int position) {
        Recommend.ResultBean bean = fList.get(position);
       FrescoUtil.getInstance().myRound(bean.getLogo(),holder.sdv);
       holder.tname.setText(bean.getName());
       holder.dz.setText(bean.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = bean.getId();
                fOnCheck.getid(id);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fList.size();
    }

    public class RecommendViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdv)
        SimpleDraweeView sdv;
        @BindView(R.id.tname)
        TextView tname;
        @BindView(R.id.dz)
        TextView dz;
        public RecommendViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    onCheck fOnCheck;

    public void setOnCheck(onCheck onCheck) {
        fOnCheck = onCheck;
    }

    public interface onCheck{
        void getid(int i);
}
}
