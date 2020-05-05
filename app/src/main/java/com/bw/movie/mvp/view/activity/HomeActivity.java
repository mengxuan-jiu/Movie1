package com.bw.movie.mvp.view.activity;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.mvp.view.fragnet.CinemaFragment;
import com.bw.movie.mvp.view.fragnet.FilmFragment;
import com.bw.movie.mvp.view.fragnet.MineFragment;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.m_vp)
    ViewPager mVp;
    @BindView(R.id.m_rb_film)
    RadioButton mRbFilm;
    @BindView(R.id.m_rb_cinema)
    RadioButton mRbCinema;
    @BindView(R.id.m_rb_mine)
    RadioButton mRbMine;
    @BindView(R.id.m_rg)
    RadioGroup mRg;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_hain;
    }

    @Override
    protected void initDate() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new FilmFragment());
        list.add(new CinemaFragment());
        list.add(new MineFragment());
        mVp.setOffscreenPageLimit(3);
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });


    }

    @Override
    protected void initView() {
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            @Override
            public void onPageSelected(int position) {
                mRg.check(mRg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @OnClick({R.id.m_rb_film, R.id.m_rb_cinema, R.id.m_rb_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_rb_film:
              mVp.setCurrentItem(0);
                break;
            case R.id.m_rb_cinema:
                mVp.setCurrentItem(1);
                break;
            case R.id.m_rb_mine:
               mVp.setCurrentItem(2);
                break;
        }
    }
}
