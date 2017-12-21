package com.example.arturmusayelyan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by artur.musayelyan on 21/12/2017.
 */

public class MyFragmentSecond extends Fragment implements View.OnClickListener {
    private TextView titleTextView;
    public MyFragmentSecond(){

    }

    public static MyFragmentSecond newInstance() {
         Bundle args = new Bundle();
         MyFragmentSecond fragment = new MyFragmentSecond();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment_my,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleTextView=view.findViewById(R.id.title_tv_second_fragment);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_tv_second_fragment:
                Toast.makeText(getActivity(), "Click in fragment", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
