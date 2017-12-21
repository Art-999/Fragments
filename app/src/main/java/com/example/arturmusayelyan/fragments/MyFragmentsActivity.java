package com.example.arturmusayelyan.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by artur.musayelyan on 21/12/2017.
 */

public class MyFragmentsActivity extends AppCompatActivity implements View.OnClickListener, Communicator {
    private Button attachButton;
    private MyFragmentFirst myFragmentFirst;
    private MyFragmentSecond myFragmentSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_my);
        attachButton = findViewById(R.id.attach_fragment_button);
        attachButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.attach_fragment_button:
                myFragmentFirst = MyFragmentFirst.newInstance();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_for_myfirstfragment, myFragmentFirst, "fragmentFirst");
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    public void addSecondFragment() {
        myFragmentSecond = MyFragmentSecond.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_for_mysecondfragment, myFragmentSecond, "secondFragment");
        fragmentTransaction.commit();
    }

    @Override
    public void removeSecondFragment() {
        if (myFragmentSecond != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.remove(myFragmentSecond);
            fragmentTransaction.commit();
        }
    }
}
