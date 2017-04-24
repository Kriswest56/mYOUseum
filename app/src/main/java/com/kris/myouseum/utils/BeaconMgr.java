package com.kris.myouseum.utils;

import android.app.Application;

import com.estimote.coresdk.common.config.EstimoteSDK;
import com.estimote.coresdk.observation.region.Region;
import com.estimote.coresdk.service.BeaconManager;
import java.util.UUID;

/**
 * Created by gnyama200 on 4/23/2017.
 */

public class BeaconMgr extends Application{

    @Override
    public void onCreate(){
        super.onCreate();

        EstimoteSDK.initialize(this, Constants.APP_ID, Constants.APP_TOKEN);
        EstimoteSDK.enableDebugLogging(true);

    }

}
