package com.mobatia.nasmanila.fragments.calendar.model;

import com.mobatia.nasmanila.activities.home.BannerResponseModel;

import java.util.ArrayList;

public class CalendarResponseModel {
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

        public String getCalendar_url() {
            return calendar_url;
        }

        public void setCalendar_url(String calendar_url) {
            this.calendar_url = calendar_url;
        }

        private String calendar_url;



    }
}
