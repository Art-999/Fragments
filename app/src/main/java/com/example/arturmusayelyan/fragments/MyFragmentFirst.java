package com.example.arturmusayelyan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by artur.musayelyan on 21/12/2017.
 */

public class MyFragmentFirst extends Fragment implements View.OnClickListener {
    private TextView titleTextView;
    private Button attachSecondFragment;
    private Button removeSecondFragment;
    private Communicator communicator;

    public MyFragmentFirst() {

    }

    public static MyFragmentFirst newInstance() {
        Bundle args = new Bundle();
        MyFragmentFirst fragment = new MyFragmentFirst();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment_my, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleTextView = view.findViewById(R.id.title_tv);
        titleTextView.setOnClickListener(this);
        attachSecondFragment = view.findViewById(R.id.attach_second_fragment_button);
        attachSecondFragment.setOnClickListener(this);
        removeSecondFragment = view.findViewById(R.id.remove_second_fragment_button);
        removeSecondFragment.setOnClickListener(this);
        communicator = (Communicator) getActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_tv:
                Toast.makeText(getActivity(), "Click in fragment", Toast.LENGTH_LONG).show();
                break;
            case R.id.attach_second_fragment_button:
                communicator.addSecondFragment();
                break;
            case R.id.remove_second_fragment_button:
                communicator.removeSecondFragment();
                break;
        }

    }
}
