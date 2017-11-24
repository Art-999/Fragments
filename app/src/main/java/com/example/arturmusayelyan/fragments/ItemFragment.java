package com.example.arturmusayelyan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by artur.musayelyan on 24/11/2017.
 */

public class ItemFragment extends Fragment {
    public ItemFragment(){

    }
    public static ItemFragment newInstance() {

        Bundle bundle = new Bundle();

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_item,container,false);
        return view;
    }
}
