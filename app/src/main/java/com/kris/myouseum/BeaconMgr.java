package com.kris.myouseum;

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

        //  To get your AppId and AppToken you need to create new application in Estimote Cloud.
        EstimoteSDK.initialize(this, "myouseum-n4h", "8b54da5fff8035a6de87e1c1b176871b");
        // Optional, debug logging.
        EstimoteSDK.enableDebugLogging(true);

    }

}
