package com.kris.myouseum.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

import com.kris.myouseum.R;
import com.kris.myouseum.dto.Exhibit;
import com.kris.myouseum.fragment.ExhibitFragment;
import com.kris.myouseum.fragment.HomeScreenFragment;
import com.kris.myouseum.utils.Constants;
import com.kris.myouseum.utils.ExhibitInterface;

public class MainActivity extends Activity implements ExhibitInterface {


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

}
