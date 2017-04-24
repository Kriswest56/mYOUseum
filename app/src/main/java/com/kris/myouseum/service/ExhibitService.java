package com.kris.myouseum.service;

import com.kris.myouseum.dto.Exhibit;

/**
 * Created by Kris on 4/23/2017.
 */

public interface ExhibitService {

    public void saveExhibit(Exhibit exhibit);

    public Exhibit getExhibit(String id);

    public void deleteExhibit(String id);

}
