package com.kris.myouseum.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kris.myouseum.R;
import com.kris.myouseum.service.ExhibitServiceImpl;

import butterknife.ButterKnife;
import io.realm.Realm;


public class ExhibitFragment extends Fragment {

    Realm myRealm;
    ExhibitServiceImpl exhibitService = ExhibitServiceImpl.getInstance();

    public ExhibitFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        myRealm = Realm.getInstance(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exhibit, container, false);

        ButterKnife.bind(this, v);

        exhibitService.seedData(myRealm);

        return v;
    }

}
