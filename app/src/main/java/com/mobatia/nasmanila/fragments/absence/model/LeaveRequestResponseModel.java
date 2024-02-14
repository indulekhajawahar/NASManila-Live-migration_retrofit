package com.mobatia.nasmanila.fragments.absence.model;

import com.mobatia.nasmanila.activities.cca.model.CCAModel;
import com.mobatia.nasmanila.fragments.cca.model.CcaDetailsResponseModel;

import java.util.ArrayList;

public class LeaveRequestResponseModel {
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

        public ArrayList<LeavesModel> getData() {
            return requests;
        }

        public void setData(ArrayList<LeavesModel> data) {
            this.requests = data;
        }


        private ArrayList<LeavesModel> requests;




    }
}
