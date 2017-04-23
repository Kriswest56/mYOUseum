package com.kris.myouseum;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import butterknife.ButterKnife;

import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;
import com.estimote.coresdk.recognition.packets.Nearable;
import com.estimote.coresdk.service.BeaconManager;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private BeaconManager beaconManager;
    private  String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment frag = new HomeScreenFragment();
        ft.replace(R.id.fragment_frame, frag);
        ft.commit();

        ButterKnife.bind(this);

        beaconManager = new BeaconManager(this);

        beaconManager.setNearableListener(new BeaconManager.NearableListener() {
                @Override
                public void onNearablesDiscovered(List<Nearable> nearables) {
                   Log.e(TAG, "Discovered Nearables: " + nearables);
                }
            }

        );

    }

    @Override
    protected void onStart() {
        super.onStart();
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startNearableDiscovery();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //this checks dependencies
        SystemRequirementsChecker.checkWithDefaultDialogs(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        beaconManager.startNearableDiscovery();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.disconnect();
    }
}
