package com.bw.movie.mvp.view.adapter.cinema;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.bw.movie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MengsFragment extends Fragment {


    public MengsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mengs, container, false);
    }

}
