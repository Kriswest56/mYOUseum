package com.kris.myouseum;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import butterknife.ButterKnife;
import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment frag = new HomeScreenFragment();
        ft.replace(R.id.fragment_frame, frag);
        ft.commit();

        ButterKnife.bind(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //this checks dependencies
        SystemRequirementsChecker.checkWithDefaultDialogs(this);

    }
}
