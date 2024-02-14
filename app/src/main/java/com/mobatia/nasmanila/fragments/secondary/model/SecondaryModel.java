package com.mobatia.nasmanila.fragments.secondary.model;

import com.mobatia.nasmanila.fragments.primary.model.PrimaryModel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by RIJO K JOSE on 25/1/17.
 */
public class SecondaryModel implements Serializable{
    String id;
    public ArrayList<PrimaryModel> getmPrimaryModel() {
        return mPrimaryModel;
    }

    public void setmPrimaryModel(ArrayList<PrimaryModel> mPrimaryModel) {
        this.mPrimaryModel = mPrimaryModel;
    }

    ArrayList<PrimaryModel>mPrimaryModel;

    public String getmId() {
        return id;
    }

    public void setmId(String mId) {
        this.id = mId;
    }

    public String getmName() {
        return name;
    }

    public void setmName(String mName) {
        this.name = mName;
    }

    public String getmFile() {
        return file;
    }

    public void setmFile(String mFile) {
        this.file = mFile;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    String name;
    String file,mTitle,mDescription;


}
