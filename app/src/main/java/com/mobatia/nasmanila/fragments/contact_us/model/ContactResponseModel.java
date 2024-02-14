package com.mobatia.nasmanila.fragments.contact_us.model;

import com.mobatia.nasmanila.fragments.notifications_new.model.NotificationResponseModel;
import com.mobatia.nasmanila.fragments.notifications_new.model.PushNotificationModelNew;

import java.util.ArrayList;

public class ContactResponseModel {
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
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public ArrayList<ContactUsModel> getContacts() {
            return contacts;
        }

        public void setContacts(ArrayList<ContactUsModel> contacts) {
            this.contacts = contacts;
        }

        private String description;
        private String latitude;
        private String longitude;
        private ArrayList<ContactUsModel> contacts;

    }
}
