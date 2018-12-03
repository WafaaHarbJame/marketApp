package com.h2oapp.h2o.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.h2oapp.h2o.R;


public class NewsFragment extends Fragment {
    View root_view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        root_view = inflater.inflate(R.layout.fragment_news, container, false);

        return root_view;
    }

}