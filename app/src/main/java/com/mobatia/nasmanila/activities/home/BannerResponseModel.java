package com.mobatia.nasmanila.activities.home;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class BannerResponseModel {
    private String responsecode;
    private ResponseData response;
    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public ResponseData getResponse() {
        return response;
    }
    public static class ResponseData {
        private String response;
        private String statuscode;
        private ArrayList<String> data;
        private String android_app_version;
        private String ios_app_version;

        public String getAndroid_app_url() {
            return android_app_url;
        }

        public void setAndroid_app_url(String android_app_url) {
            this.android_app_url = android_app_url;
        }

        public String getIos_app_url() {
            return ios_app_url;
        }

        public void setIos_app_url(String ios_app_url) {
            this.ios_app_url = ios_app_url;
        }

        private String android_app_url;
        private String ios_app_url;
        public ArrayList<String> getData() {
            return data;
        }

        public void setData(ArrayList<String> data) {
            this.data = data;
        }

        public String getAndroid_app_version() {
            return android_app_version;
        }

        public void setAndroid_app_version(String android_app_version) {
            this.android_app_version = android_app_version;
        }

        public String getIos_app_version() {
            return ios_app_version;
        }

        public void setIos_app_version(String ios_app_version) {
            this.ios_app_version = ios_app_version;
        }



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




    }
}