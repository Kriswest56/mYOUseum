package com.kris.myouseum.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;

import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;
import com.estimote.coresdk.recognition.packets.Nearable;
import com.estimote.coresdk.service.BeaconManager;
import com.kris.myouseum.R;
import com.kris.myouseum.fragment.ExhibitFragment;
import com.kris.myouseum.fragment.HomeScreenFragment;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainActivity extends Activity {


    private String TAG = MainActivity.class.getSimpleName();


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





}
