package com.kris.myouseum;

import android.app.Application;

import com.estimote.coresdk.service.BeaconManager;

/**
 * Created by gnyama200 on 4/23/2017.
 */

public class BeaconMgr extends Application{
    private BeaconManager beaconManager;

    @Override
    public void onCreate(){
        super.onCreate();
        beaconManager = new BeaconManager(getApplicationContext());
    }

}
