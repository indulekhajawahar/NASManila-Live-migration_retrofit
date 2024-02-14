package com.mobatia.nasmanila.activities.staff_directory.model;

import com.mobatia.nasmanila.fragments.social_media.model.StaffResponseModel;

import java.util.ArrayList;

public class StaffCategoriResponseModel {
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

        private String banner_image;
        public ArrayList<StaffModel> getData() {
            return data;
        }

        public void setData(ArrayList<StaffModel> data) {
            this.data = data;
        }


        private ArrayList<StaffModel> data;




    }
}
