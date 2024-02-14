package com.mobatia.nasmanila.fragments.category1.model;

import com.mobatia.nasmanila.fragments.parent_essentials.model.ParentListModel;

import java.util.ArrayList;

public class EnrichmentEssentialsModel {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    String banner_image;
    String description;
    String contact_email;
}
