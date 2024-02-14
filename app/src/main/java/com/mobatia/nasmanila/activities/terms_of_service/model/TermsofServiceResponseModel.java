package com.mobatia.nasmanila.activities.terms_of_service.model;

import com.mobatia.nasmanila.fragments.contact_us.model.ContactResponseModel;
import com.mobatia.nasmanila.fragments.contact_us.model.ContactUsModel;

import java.util.ArrayList;

public class TermsofServiceResponseModel {
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


        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        private Data data;



    }
    public static class Data {
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private String title;
        private String description;

    }
}
