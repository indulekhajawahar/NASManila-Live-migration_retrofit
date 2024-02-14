package com.mobatia.nasmanila.fragments.about_us.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by RIJO K JOSE on 25/1/17.
 */
public class AboutusModel implements Serializable{
    Integer id;
    String url;
    String webUrl;
    String email;
    String title;
    String tab_type;
    ArrayList<AboutusModel> aboutusModelArrayList;
    ArrayList<AboutusModel> mFacilitylListArray;

    public String getTab_type() {
        return tab_type;
    }

    public void setTab_type(String tab_type) {
        this.tab_type = tab_type;
    }

    public ArrayList<AboutusModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<AboutusModel> items) {
        this.items = items;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }

    ArrayList<AboutusModel> items;

    String description;
    String banner_image;
    String itemPdfUrl;
    String itemTitle;


    public String getTabType() {
        return tab_type;
    }

    public void setTabType(String tabType) {
        tab_type = tabType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        url = url;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<AboutusModel> getAboutusModelArrayList() {
        return aboutusModelArrayList;
    }

    public void setAboutusModelArrayList(ArrayList<AboutusModel> aboutusModelArrayList) {
        this.aboutusModelArrayList = aboutusModelArrayList;
    }

    public String getItemDesc() {
        return description;
    }

    public void setItemDesc(String itemDesc) {
        this.description = itemDesc;
    }

    public String getImageUrl() {
        return banner_image;
    }

    public void setImageUrl(String itemImageUrl) {
        this.banner_image = itemImageUrl;
    }

    public ArrayList<AboutusModel> getmFacilitylListArray() {
        return mFacilitylListArray;
    }

    public void setmFacilitylListArray(ArrayList<AboutusModel> mFacilitylListArray) {
        this.mFacilitylListArray = mFacilitylListArray;
    }

    public String getItemPdfUrl() {
        return itemPdfUrl;
    }

    public void setItemPdfUrl(String itemPdfUrl) {
        this.itemPdfUrl = itemPdfUrl;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
}
