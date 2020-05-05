package com.bw.movie.mvp.view.activity;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.mvp.view.fragnet.movie.ComingSoonFragment;
import com.bw.movie.mvp.view.fragnet.movie.FinHotFragment;
import com.bw.movie.mvp.view.fragnet.movie.FindReleaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;


public class MovieListActivity extends BaseActivity {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    ArrayList<String> ss = new ArrayList<>();
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_movie_list;
    }

    @Override
    protected void initDate() {
        ArrayList<Fragment> list = new ArrayList<>();

        list.add(new FinHotFragment());
        list.add(new FindReleaseFragment());
        list.add(new ComingSoonFragment());
        ss.add("正在热映");
        ss.add("即将上映");
        ss.add("热门电影");
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return ss.get(position);
            }
        });
        tab.setupWithViewPager(vp);
    }

    @Override
    protected void initView() {
        vp.setOffscreenPageLimit(5);
    }


}
