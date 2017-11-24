package com.example.arturmusayelyan.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MyExample1 extends AppCompatActivity {
    private RelativeLayout activityLayout;
    //FragmentTransaction fragmentTransaction;
    ItemFragment itemFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_example1);
        activityLayout = findViewById(R.id.mainActivity_layout);


    }

    public void onClick(View view) {
        if (view.getId() == R.id.fragment_add_btn) {
            itemFragment = new ItemFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, itemFragment);
            fragmentTransaction.addToBackStack("stack");
            fragmentTransaction.commit();
            System.out.println("Fragment count " + fragmentManager.getFragments().size());
        } else if (view.getId() == R.id.fragment_remove_btn) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(itemFragment);
            fragmentTransaction.commit();
        }
    }
}
