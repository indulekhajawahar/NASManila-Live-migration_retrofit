package com.mobatia.nasmanila.fragments.parents_evening.model;

import com.mobatia.nasmanila.fragments.social_media.model.SocialMediaModel;
import com.mobatia.nasmanila.fragments.social_media.model.SocialMediaResponseModel;

import java.util.ArrayList;

public class StudentResponseModel {
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


        public ArrayList<StudentModel> getData() {
            return data;
        }

        public void setData(ArrayList<StudentModel> data) {
            this.data = data;
        }


        private ArrayList<StudentModel> data;




    }
}
