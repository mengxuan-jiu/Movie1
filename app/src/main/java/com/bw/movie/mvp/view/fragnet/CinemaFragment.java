package com.bw.movie.mvp.view.fragnet;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.mvp.view.fragnet.cinema.DomainFragment;
import com.bw.movie.mvp.view.fragnet.cinema.NearbyFragment;
import com.bw.movie.mvp.view.fragnet.cinema.RecommendFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaFragment extends BaseFragment {


    ArrayList<String> ss = new ArrayList<>();
    @BindView(R.id.taby)
    TabLayout taby;
    @BindView(R.id.vpy)
    ViewPager vpy;

    @Override
    protected void initDate() {


        ArrayList<Fragment> list1 = new ArrayList<>();
        list1.add(new RecommendFragment());
        list1.add(new NearbyFragment());
        list1.add(new DomainFragment());
        ss.add("推荐影院");
        ss.add("附近电院");
        ss.add("北京");




        vpy.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list1.get(position);
            }

            @Override
            public int getCount() {
                return list1.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return ss.get(position);
            }
        });
        taby.setupWithViewPager(vpy);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected void initView(View inflate) {
        vpy.setOffscreenPageLimit(3);
    }

    @Override
    protected BasePresenter initPrenher() {
        return null;
    }


}



