package com.kris.myouseum.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

import com.kris.myouseum.R;
import com.kris.myouseum.fragment.ExhibitFragment;
import com.kris.myouseum.fragment.HomeScreenFragment;

public class MainActivity extends Activity {


    private String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment frag = new ExhibitFragment();
        ft.replace(R.id.fragment_frame, frag);

        ft.commit();

        ButterKnife.bind(this);

    }





}
