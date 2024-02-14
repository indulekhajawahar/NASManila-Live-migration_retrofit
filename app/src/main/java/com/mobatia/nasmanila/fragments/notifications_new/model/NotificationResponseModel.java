package com.mobatia.nasmanila.fragments.notifications_new.model;

import com.mobatia.nasmanila.fragments.calendar.model.CalendarResponseModel;

import java.util.ArrayList;

public class NotificationResponseModel {
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

        public ArrayList<PushNotificationModelNew> getData() {
            return data;
        }

        public void setData(ArrayList<PushNotificationModelNew> data) {
            this.data = data;
        }

        private ArrayList<PushNotificationModelNew> data;



    }
}
