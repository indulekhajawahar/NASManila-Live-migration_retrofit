package com.mobatia.nasmanila.fragments.category1.model;

import com.mobatia.nasmanila.fragments.secondary.model.SecondaryModel;

import java.util.ArrayList;

public class CcaResponseModel {
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

        public String getContact_email() {
            return contact_email;
        }

        public void setContact_email(String contact_email) {
            this.contact_email = contact_email;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private String banner_image;
        private String contact_email;
        private String description;
        public ArrayList<SecondaryModel> getData() {
            return data;
        }

        public void setData(ArrayList<SecondaryModel> data) {
            this.data = data;
        }


        private ArrayList<SecondaryModel> data;




    }
}
