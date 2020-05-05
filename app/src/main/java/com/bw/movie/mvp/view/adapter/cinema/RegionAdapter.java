package com.bw.movie.mvp.view.adapter.cinema;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.band.cinema.FindRegionList;

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
public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.CinmaViewHolder> {
    private int fId;
    private List<FindRegionList.ResultBean> list;

    public RegionAdapter(List<FindRegionList.ResultBean> list) {

        this.list = list;
    }


    @NonNull
    @Override
    public CinmaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CinmaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.find, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CinmaViewHolder holder, int position) {
        FindRegionList.ResultBean bean = list.get(position);
        holder.text.setText(bean.getRegionName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int regionId = bean.getRegionId();
                onRegionId.getId(regionId);
                onRegionId.getDx(bean.getRegionName());

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
   public onRegionId onRegionId;

    public void setOnRegionId(RegionAdapter.onRegionId onRegionId) {
        this.onRegionId = onRegionId;
    }

    public interface onRegionId {
        void getId(int i);
        void getDx(String dx);
}

}
