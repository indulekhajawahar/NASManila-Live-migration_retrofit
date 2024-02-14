package com.mobatia.nasmanila.fragments.nas_today.model;

import com.mobatia.nasmanila.fragments.absence.model.LeaveRequestResponseModel;
import com.mobatia.nasmanila.fragments.absence.model.LeavesModel;

import java.util.ArrayList;

public class NAsTodayResponseModel {
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

        public ArrayList<NasTodayModel> getRequests() {
            return data;
        }

        public void setRequests(ArrayList<NasTodayModel> requests) {
            this.data = requests;
        }

        private String banner_image;

        public ArrayList<NasTodayModel> getData() {
            return data;
        }

        public void setData(ArrayList<NasTodayModel> data) {
            this.data = data;
        }


        private ArrayList<NasTodayModel> data;




    }
}
