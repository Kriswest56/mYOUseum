package com.kris.myouseum.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;
import com.estimote.coresdk.recognition.packets.Nearable;
import com.estimote.coresdk.service.BeaconManager;
import com.kris.myouseum.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;


public class HomeScreenFragment extends Fragment {
    private ArrayAdapter<String> discoveredBeaconsArrayAdapter;
    private ListView lv_discoveredBeacons;
    private BeaconManager beaconManager;
    private String TAG = "HomeScreenFragment";
    public HomeScreenFragment() {}




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_screen, container, false);


        ButterKnife.bind(this, v);

        discoveredBeaconsArrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.device_name);
        lv_discoveredBeacons = (ListView)v.findViewById(R.id.lv_found_devices);

        startNearableDetection();
        return v;
    }

    private void startNearableDetection(){

        beaconManager = new BeaconManager(getActivity());
        beaconManager.setBackgroundScanPeriod(TimeUnit.SECONDS.toMillis(5), 0);
        beaconManager.setForegroundScanPeriod(TimeUnit.SECONDS.toMillis(5), 0);
        beaconManager.setNearableListener(new BeaconManager.NearableListener() {
            @Override
            public void onNearablesDiscovered(List<Nearable> nearables) {
                if(nearables.size() > 0){
                    discoveredBeaconsArrayAdapter.clear();
                    Log.e(TAG, "Discovered Nearables: " + nearables.get(0).getUniqueKey());
                    for(Nearable nearable: nearables){
                        //ToDo what information we want to display on the deviceList
                        //discoveredBeaconsArrayAdapter.clear();
                        Log.e(TAG, "Nearables: " +nearable.getUniqueKey()+ " unique name: " + nearable.getClass().getName());
                        discoveredBeaconsArrayAdapter.add(nearable.getUniqueKey() + "\n" + nearable.getClass().getName());

                    }
                    lv_discoveredBeacons.setAdapter(discoveredBeaconsArrayAdapter);
                    lv_discoveredBeacons.setOnItemClickListener(adapterBeaconClickListener);
                }else{
                    Log.e(TAG,"Nothing discovered");
                    String noBeacons = "No Beacons in the Vicinity".toString();
                    discoveredBeaconsArrayAdapter.clear();
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
    public void onResume() {
        super.onResume();
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startNearableDiscovery();
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        beaconManager.stopNearableDiscovery();
    }

    @Override
    public void onDestroyView() {
        beaconManager.disconnect();
        super.onDestroyView();
    }
}
