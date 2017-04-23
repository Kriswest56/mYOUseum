package com.kris.myouseum;

import android.app.Application;

import com.estimote.coresdk.observation.region.Region;
import com.estimote.coresdk.service.BeaconManager;
import java.util.UUID;

/**
 * Created by gnyama200 on 4/23/2017.
 */

public class BeaconMgr extends Application{
    private BeaconManager beaconManager;

    @Override
    public void onCreate(){
        super.onCreate();
        beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
               // beaconManager.startMonitoring(new Region(
                 //       "monitored region",
                  //      UUID.fromString("B9407F30-F5F8-466E-AFF9-25556B57FE6D"),
                    //    22504, 48827));
            }
        });
    }

}
