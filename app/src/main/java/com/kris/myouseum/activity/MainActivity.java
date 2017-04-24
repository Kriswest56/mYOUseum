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
import com.kris.myouseum.fragment.HomeScreenFragment;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainActivity extends Activity {

    private BeaconManager beaconManager;
    private String TAG = MainActivity.class.getSimpleName();
    private ArrayAdapter<String> discoveredBeaconsArrayAdapter;
    private ListView lv_discoveredBeacons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment frag = new HomeScreenFragment();
        ft.replace(R.id.fragment_frame, frag);
        ft.commit();

        ButterKnife.bind(this);

        startNearableDetection();

    }

    private void startNearableDetection(){
        discoveredBeaconsArrayAdapter = new ArrayAdapter<>(this, R.layout.device_name);
        lv_discoveredBeacons = (ListView)findViewById(R.id.lv_found_devices);

        beaconManager = new BeaconManager(this);
        beaconManager.setBackgroundScanPeriod(TimeUnit.SECONDS.toMillis(5), 0);
        beaconManager.setForegroundScanPeriod(TimeUnit.SECONDS.toMillis(5), 0);
        beaconManager.setNearableListener(new BeaconManager.NearableListener() {
            @Override
            public void onNearablesDiscovered(List<Nearable> nearables) {
                if(nearables.size() > 0){
                    Log.e(TAG, "Discovered Nearables: " + nearables.get(0).getUniqueKey());
                    for(Nearable nearable: nearables){
                        //ToDo what information we want to display on the deviceList
                        discoveredBeaconsArrayAdapter.add(nearable.getUniqueKey() + "\n" + nearable.getClass().getName());
                    }
                    lv_discoveredBeacons.setAdapter(discoveredBeaconsArrayAdapter);
                    lv_discoveredBeacons.setOnItemClickListener(adapterBeaconClickListener);
                }else{
                    Log.e(TAG,"Nothing discovered");
                    String noBeacons = "No Beacons in the Vicinity".toString();
                    discoveredBeaconsArrayAdapter.add(noBeacons);
                    lv_discoveredBeacons.setAdapter(discoveredBeaconsArrayAdapter);
                }
            }
        });

    }

    /**
     * OnClick listener for all devices in the listViews
     */
    private AdapterView.OnItemClickListener adapterBeaconClickListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String info = ((TextView) view).getText().toString();
            Log.e(TAG, "This was clicked: " + info);

            //ToDo What happens when a beacon is selected
        }
    };

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
        SystemRequirementsChecker.checkWithDefaultDialogs(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        beaconManager.stopNearableDiscovery();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.disconnect();
    }


}
