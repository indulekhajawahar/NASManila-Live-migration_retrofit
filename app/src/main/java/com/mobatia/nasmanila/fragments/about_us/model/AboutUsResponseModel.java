package com.mobatia.nasmanila.fragments.about_us.model;

import com.mobatia.nasmanila.fragments.contact_us.model.ContactResponseModel;
import com.mobatia.nasmanila.fragments.contact_us.model.ContactUsModel;
import com.mobatia.nasmanila.fragments.notifications_new.model.PushNotificationModelNew;

import java.util.ArrayList;

public class AboutUsResponseModel {
    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public ResponseData getResponse() {
        return response;
    }

    public void setResponse(ResponseData response) {
        this.response = response;
    }

    private String responsecode;
    private ResponseData response;
    public static class ResponseData {
        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }

        public String getStatuscode() {
            return statuscode;
        }

        public void setStatuscode(String statuscode) {
            this.statuscode = statuscode;
        }

        private String response;
        private String statuscode;

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

        public String getWebsite_link() {
            return website_link;
        }

        public void setWebsite_link(String website_link) {
            this.website_link = website_link;
        }

        public ArrayList<AboutusModel> getData() {
            return data;
        }

        public void setData(ArrayList<AboutusModel> data) {
            this.data = data;
        }

        private String banner_image;
        private String description;
        private String contact_email;

        private String website_link;

        private ArrayList<AboutusModel> data;




    }

}
