package com.mobatia.nasmanila.fragments.parents_evening.model;

import java.io.Serializable;

/**
 * Created by RIJO K JOSE on 25/1/17.
 */
public class StaffModel implements Serializable{

    String id;

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
    String mClass;
    String mSection;

    public String getmPhoto() {
        return staff_photo;
    }

    public void setmPhoto(String mPhoto) {
        this.staff_photo = mPhoto;
    }

    public String getmHouse() {
        return mHouse;
    }

    public void setmHouse(String mHouse) {
        this.mHouse = mHouse;
    }

    public String getmSection() {
        return mSection;
    }

    public void setmSection(String mSection) {
        this.mSection = mSection;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    String staff_photo;
    String mHouse;


}
