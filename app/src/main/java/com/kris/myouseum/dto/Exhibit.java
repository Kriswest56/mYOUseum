package com.kris.myouseum.dto;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by Kris on 4/23/2017.
 */

public class Exhibit extends RealmObject implements Serializable {

    private String id;
    private String title;
    private String details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
