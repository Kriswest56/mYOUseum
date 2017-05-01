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
    public ArrayList<Exhibit> getAllExhibits(Realm realm) {

        ArrayList<Exhibit> exhibitList = new ArrayList<Exhibit>();
        RealmResults<Exhibit> results = realm.where(Exhibit.class).findAll();

        if(results.size() > 0){
            for(Exhibit e : results) {
                exhibitList.add(e);
                Log.d("ID: ", e.getId());
            }
        }else{
            Log.d("Size 0: ", "Seeding data...");
            seedExhibitData(realm);
            results = realm.where(Exhibit.class).findAll();
            for(Exhibit e : results) {
                exhibitList.add(e);
                Log.d("ID: ", e.getId());
            }
        }

        return exhibitList;
    }

    @Override
    public void deleteExhibit(String id) {



    }

    @Override
    public void deleteAllExhibits(Realm realm){

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Exhibit> rows = realm.where(Exhibit.class).findAll();
                rows.clear();
            }
        });

    }

    private void seedExhibitData(Realm realm){

        realm.beginTransaction();

        Exhibit exhibit = realm.createObject(Exhibit.class);
        exhibit.setId("7f9af0e883874650");
        exhibit.setTitle("Bed");
        exhibit.setArtifactName("Montezuma");
        exhibit.setDetails("Montezuma II (c. 1466 - June 1520) was the ninth ruler of the Aztec Empire. He was killed during the Spanish conquest. According to the Spanish, he was killed by his own subjects; however, it is believed to be more likely that the Spanish murdered him after he served his purpose to them.");

        Exhibit exhibit1 = realm.createObject(Exhibit.class);
        exhibit1.setId("5eb4bc7c583e4216");
        exhibit1.setTitle("Fridge");
        exhibit1.setArtifactName("Leonardo da Vinci");
        exhibit1.setDetails("Leonardo di ser Piero da Vinci 15 April 1452 – 2 May 1519), more commonly Leonardo da Vinci or simply Leonardo, was an Italian polymath whose areas of interest included invention, painting, sculpting, architecture, science, music, mathematics, engineering, literature, anatomy, geology, astronomy, botany, writing, history, and cartography. He has been variously called the father of palaeontology, ichnology, and architecture, and is widely considered one of the greatest painters of all time. Sometimes credited with the inventions of the parachute, helicopter and tank, he epitomised the Renaissance humanist ideal.");

        Exhibit exhibit2 = realm.createObject(Exhibit.class);
        exhibit2.setId("142a9e166aae36ac");
        exhibit2.setTitle("Bag");
        exhibit2.setArtifactName("Alan Turing");
        exhibit2.setDetails("Alan Mathison Turing 23 June 1912 – 7 June 1954) was an English computer scientist, mathematician, logician, cryptanalyst and theoretical biologist. He was highly influential in the development of theoretical computer science, providing a formalisation of the concepts of algorithm and computation with the Turing machine, which can be considered a model of a general purpose computer. Turing is widely considered to be the father of theoretical computer science and artificial intelligence.");

        Exhibit exhibit3 = realm.createObject(Exhibit.class);
        exhibit3.setId("f4a5ca2980ebe3a2");
        exhibit3.setTitle("Bike");
        exhibit3.setArtifactName("Mars Rover");
        exhibit3.setDetails("A Mars rover is an automated motor vehicle that propels itself across the surface of the planet Mars upon arrival. Rovers have several advantages over stationary landers: they examine more territory, and they can be directed to interesting features, they can place themselves in sunny positions to weather winter months, and they can advance the knowledge of how to perform very remote robotic vehicle control.");

        Exhibit exhibit4 = realm.createObject(Exhibit.class);
        exhibit4.setId("16bcb66410a19fcf");
        exhibit4.setTitle("Chair");
        exhibit4.setArtifactName("Shaka Zulu");
        exhibit4.setDetails("Shaka kaSenzangakhona (c. 1787 – 22 September 1828), also known as Shaka Zulu was one of the most influential monarchs of the Zulu Kingdom. He was born near present-day Melmoth, KwaZulu-Natal Province. In his early days, Shaka served as a warrior under the sway of Dingiswayo.");

        Exhibit exhibit5 = realm.createObject(Exhibit.class);
        exhibit5.setId("b7c2d87a92a721fa");
        exhibit5.setTitle("Dog");
        exhibit5.setArtifactName("Charles darwin");
        exhibit5.setDetails("Charles Robert darwin, 12 February 1809 – 19 April 1882) was an English naturalist, geologist and biologist, best known for his contributions to the science of evolution. He established that all species of life have descended over time from common ancestors, and in a joint publication with Alfred Russel Wallace introduced his scientific theory that this branching pattern of evolution resulted from a process that he called natural selection, in which the struggle for existence has a similar effect to the artificial selection involved in selective breeding.");

        Exhibit exhibit6 = realm.createObject(Exhibit.class);
        exhibit6.setId("5d56806c5e72f807");
        exhibit6.setTitle("Door");
        exhibit6.setTitle("Macintosh");
        exhibit6.setDetails("The Macintosh (branded as Mac since 1998) is a series of personal computers (PCs) designed, developed, and marketed by Apple Inc. Steve Jobs introduced the original Macintosh computer on January 24, 1984. This was the company's first mass-market personal computer featuring an integral graphical user interface and mouse.");

        Exhibit exhibit7 = realm.createObject(Exhibit.class);
        exhibit7.setId("f3cec0cb33367c00");
        exhibit7.setTitle("Generic");
        exhibit7.setArtifactName("Augusta Ada King-Noel, Countess of Lovelace");
        exhibit7.setDetails("Augusta Ada King-Noel, Countess of Lovelace (Byron; 10 December 1815 – 27 November 1852) was an English mathematician and writer, chiefly known for her work on Charles Babbage's proposed mechanical general-purpose computer, the Analytical Engine. She was the first to recognise that the machine had applications beyond pure calculation, and created the first algorithm intended to be carried out by such a machine. As a result, she is often regarded as the first to recognise the full potential of a \"computing machine\" and the first computer programmer ");

        Exhibit exhibit8 = realm.createObject(Exhibit.class);
        exhibit8.setId("ba4566f456f188d2");
        exhibit8.setTitle("Shoe");
        exhibit8.setArtifactName("Nikola Tesla");
        exhibit8.setDetails("Nikola Tesla (10 July 1856 – 7 January 1943) was a Serbian-American inventor, electrical engineer, mechanical engineer, physicist, and futurist who is best known for his contributions to the design of the modern alternating current (AC) electricity supply system. Born and raised in the Austrian Empire, Tesla received an advanced education in engineering and physics in the 1870s and gained practical experience in the early 1880s working in telephony and at Continental Edison in the new electric power industry. He immigrated to the United States in 1884, where he would become a naturalized citizen. He worked for a short time at the Edison Machine Works in New York City before he struck out on his own. With the help of partners to finance and market his ideas, Tesla set up laboratories and companies in New York to develop a range of electrical and mechanical devices.");

        Exhibit exhibit9 = realm.createObject(Exhibit.class);
        exhibit9.setId("9b4b65520c974591");
        exhibit9.setTitle("Car");
        exhibit9.setArtifactName("Wright Brothers");
        exhibit9.setDetails("The Wright brothers, Orville (August 19, 1871 – January 30, 1948) and Wilbur (April 16, 1867 – May 30, 1912), were two American brothers, inventors, and aviation pioneers who are generally credited[1][2][3] with inventing, building, and flying the world's first successful airplane. They made the first controlled, sustained flight of a powered, heavier-than-air aircraft on December 17, 1903, four miles south of Kitty Hawk, North Carolina. In 1904–05 the brothers developed their flying machine into the first practical fixed-wing aircraft. Although not the first to build and fly experimental aircraft, the Wright brothers were the first to invent aircraft controls that made fixed-wing powered flight possible.");

        realm.commitTransaction();

    }

}
