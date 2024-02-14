package com.mobatia.nasmanila.fragments.cca.model;

import com.mobatia.nasmanila.activities.cca.model.CCAModel;
import com.mobatia.nasmanila.fragments.category1.model.CcaResponseModel;
import com.mobatia.nasmanila.fragments.secondary.model.SecondaryModel;

import java.util.ArrayList;

public class CcaDetailsResponseModel {
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

        public ArrayList<CCAModel> getData() {
            return data;
        }

        public void setData(ArrayList<CCAModel> data) {
            this.data = data;
        }


        private ArrayList<CCAModel> data;




    }
}
