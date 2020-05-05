package com.bw.movie.mvp.view.adapter.cinema;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.cinema.Nearby;
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
 * @类名NearAdapter
 **/
public class NearAdapter extends RecyclerView.Adapter<NearAdapter.NearViewHolder> {
    private List<Nearby.ResultBean> list;

    public NearAdapter(List<Nearby.ResultBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public NearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NearViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nearby, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NearViewHolder holder, int position) {
        Nearby.ResultBean resultBean = list.get(position);
        holder.name.setText(resultBean.getName());
        holder.tt.setText(resultBean.getAddress());
        int id = resultBean.getId();
        FrescoUtil.getInstance().myRound(resultBean.getLogo(),holder.sdv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fOnCheck.getid(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NearViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdv)
        SimpleDraweeView sdv;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.tt)
        TextView tt;

        public NearViewHolder(@NonNull View itemView) {
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
