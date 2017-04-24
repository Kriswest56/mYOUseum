package com.kris.myouseum;

import io.realm.RealmObject;

/**
 * Created by Kris on 4/23/2017.
 */

public class Exhibit extends RealmObject {

    private String id;
    private String title;

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
}
