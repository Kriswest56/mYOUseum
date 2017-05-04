package com.kris.myouseum.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import butterknife.ButterKnife;

import com.kris.myouseum.R;
import com.kris.myouseum.dto.Exhibit;
import com.kris.myouseum.fragment.ExhibitFragment;
import com.kris.myouseum.fragment.HomeScreenFragment;
import com.kris.myouseum.utils.Constants;
import com.kris.myouseum.utils.ExhibitInterface;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;

public class MainActivity extends Activity implements ExhibitInterface {


    private String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_COARSE_LOCATION_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment frag = new HomeScreenFragment();
        ft.replace(R.id.fragment_frame, frag);

        ft.commit();

        doDiscovery();
        ButterKnife.bind(this);

    }

    @Override
    public void handleDisplay(Exhibit exhibit){

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment frag;

        if(exhibit != null){
            frag = new ExhibitFragment();
            Bundle b = new Bundle();
            b.putSerializable(Constants.EXHIBIT_OBJECT, exhibit);
            frag.setArguments(b);
        }else{
            frag = new HomeScreenFragment();
        }

        ft.replace(R.id.fragment_frame, frag);
        ft.commit();

    }

    private void doDiscovery() {
        android.util.Log.e(TAG, "/t/t doDiscovery() : needs explicit acceptance or coarse");
        int hasPermission = ActivityCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION);

        if (!(hasPermission == PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_COARSE_LOCATION_PERMISSIONS);

        }
    }

}
