package com.kris.myouseum.service;

import android.util.Log;

import com.kris.myouseum.dto.Exhibit;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Kris on 4/23/2017.
 */

public class ExhibitServiceImpl implements ExhibitService {

    private static ExhibitServiceImpl instance = null;

    public static ExhibitServiceImpl getInstance(){

        if(instance == null){
            instance = createInstance();
        }

        return instance;

    }

    private static synchronized ExhibitServiceImpl createInstance(){

        if(instance == null){
            instance = new ExhibitServiceImpl();
        }

        return instance;
    }

    @Override
    public void saveExhibit(Exhibit exhibit) {

    }

    @Override
    public Exhibit getExhibit(String id) {
        return null;
    }

    @Override
    public void deleteExhibit(String id) {

    }

    @Override
    public void seedData(Realm realm){

        RealmResults<Exhibit> results = realm.where(Exhibit.class).findAll();

        if(results.size() > 0){
            for(Exhibit e : results) {
                Log.d("ID: ", e.getId());
            }
        }else{
            Log.d("Size 0: ", "Seeding data...");
            populateExhibitData(realm);
        }

    }

    private void populateExhibitData(Realm realm){

        realm.beginTransaction();

        Exhibit exhibit = realm.createObject(Exhibit.class);
        exhibit.setId("7f9af0e883874650");
        exhibit.setTitle("Bed");
        exhibit.setDetails("Bed Details");

        Exhibit exhibit1 = realm.createObject(Exhibit.class);
        exhibit1.setId("5eb4bc7c583e4216");
        exhibit1.setTitle("Fridge");
        exhibit1.setDetails("Fridge Details");

        Exhibit exhibit2 = realm.createObject(Exhibit.class);
        exhibit2.setId("142a9e166aae36ac");
        exhibit2.setTitle("Bag");
        exhibit2.setDetails("Bag Details");

        Exhibit exhibit3 = realm.createObject(Exhibit.class);
        exhibit3.setId("f4a5ca2980ebe3a2");
        exhibit3.setTitle("Bike");
        exhibit3.setDetails("Bike Details");

        Exhibit exhibit4 = realm.createObject(Exhibit.class);
        exhibit4.setId("16bcb66410a19fcf");
        exhibit4.setTitle("Chair");
        exhibit4.setDetails("Chair Details");

        Exhibit exhibit5 = realm.createObject(Exhibit.class);
        exhibit5.setId("b7c2d87a92a721fa");
        exhibit5.setTitle("Dog");
        exhibit5.setDetails("Dog Details");

        Exhibit exhibit6 = realm.createObject(Exhibit.class);
        exhibit6.setId("5d56806c5e72f807");
        exhibit6.setTitle("Door");
        exhibit6.setDetails("Door Details");

        Exhibit exhibit7 = realm.createObject(Exhibit.class);
        exhibit7.setId("f3cec0cb33367c00");
        exhibit7.setTitle("Generic");
        exhibit7.setDetails("Generic Details");

        Exhibit exhibit8 = realm.createObject(Exhibit.class);
        exhibit8.setId("ba4566f456f188d2");
        exhibit8.setTitle("Shoe");
        exhibit8.setDetails("Shoe Details");

        Exhibit exhibit9 = realm.createObject(Exhibit.class);
        exhibit9.setId("9b4b65520c974591");
        exhibit9.setTitle("Car");
        exhibit9.setDetails("Car Details");

        realm.commitTransaction();

    }

}
