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
import com.bw.movie.band.FindComingSoonMovieBead;
import com.bw.movie.band.FindHotMovieBead;

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
public class AdapterfindComingSoonMovie extends RecyclerView.Adapter<AdapterfindComingSoonMovie.ViewHolderFindHotMovie> {


    private List<FindComingSoonMovieBead.ResultBean> list;

    public AdapterfindComingSoonMovie(List<FindComingSoonMovieBead.ResultBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderFindHotMovie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderFindHotMovie(LayoutInflater.from(parent.getContext()).inflate(R.layout.find_soon_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFindHotMovie holder, int position) {
        FindComingSoonMovieBead.ResultBean bean = list.get(position);
        String name = bean.getName();

        String imageUrl = bean.getImageUrl();
        Glide.with(holder.itemView)
                .load(imageUrl)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.encodeQualityOf(20))
                .into(holder.hImage);
        holder.hName.setText(name);
        int movieId = bean.getMovieId();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fOnitimClickListener.getid(movieId);
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
    onitimClickListener fOnitimClickListener;

    public void setOnitimClickListener(onitimClickListener onitimClickListener) {
        fOnitimClickListener = onitimClickListener;
    }

    public interface  onitimClickListener{
       void getid(int  id);
    }
}
