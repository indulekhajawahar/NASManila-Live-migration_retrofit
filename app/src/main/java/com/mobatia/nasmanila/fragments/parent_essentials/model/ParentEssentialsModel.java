package com.mobatia.nasmanila.fragments.parent_essentials.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by gayatri on 23/3/17.
 */
public class ParentEssentialsModel implements Serializable{
    String newsLetterCatId;
    String newsLetterCatName;
    ArrayList<ParentListModel> submenu;
    String name;
    String newLetterSubId;
    String banner_image;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    String link;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBannerImage() {
        return banner_image;
    }

    public void setBannerImage(String bannerImage) {
        this.banner_image = bannerImage;
    }

    public String getContactEmail() {
        return contact_email;
    }

    public void setContactEmail(String contactEmail) {
        this.contact_email = contactEmail;
    }

    String description;
    String contact_email;

    public String getNewsLetterCatId() {
        return newsLetterCatId;
    }

    public void setNewsLetterCatId(String newsLetterCatId) {
        this.newsLetterCatId = newsLetterCatId;
    }

    public String getNewsLetterCatName() {
        return newsLetterCatName;
    }

    public void setNewsLetterCatName(String newsLetterCatName) {
        this.newsLetterCatName = newsLetterCatName;
    }

    public ArrayList<ParentListModel> getNewsLetterModelArrayList() {
        return submenu;
    }

    public void setNewsLetterModelArrayList(ArrayList<ParentListModel> newsLetterModelArrayList) {
        this.submenu = newsLetterModelArrayList;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getNewLetterSubId() {
        return newLetterSubId;
    }

    public void setNewLetterSubId(String newLetterSubId) {
        this.newLetterSubId = newLetterSubId;
    }


}
