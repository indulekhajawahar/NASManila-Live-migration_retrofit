package com.mobatia.nasmanila.fragments.parents_evening.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by RIJO K JOSE on 25/1/17.
 */
public class StudentModel implements Serializable{

    String id;

    public String getGoingStatus() {
        return goingStatus;
    }

    public void setGoingStatus(String goingStatus) {
        this.goingStatus = goingStatus;
    }

    String goingStatus;

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




    String name;
    @SerializedName("class")

    String mClass;
    String section;

    public String getmPhoto() {
        return photo;
    }

    public void setmPhoto(String mPhoto) {
        this.photo = mPhoto;
    }

    public String getmHouse() {
        return house;
    }

    public void setmHouse(String mHouse) {
        this.house = mHouse;
    }

    public String getmSection() {
        return section;
    }

    public void setmSection(String mSection) {
        this.section = mSection;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    String photo;
    String house;


}
