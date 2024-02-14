package com.mobatia.nasmanila.activities.staff_directory.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Map;

public class StaffCategoriListResponseModel {
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


        public static class Data
        {
            public ArrayList<String> getDepartments() {
                return departments;
            }

            public void setDepartments(ArrayList<String> departments) {
                this.departments = departments;
            }

            public ArrayList<Map<String, ArrayList<StaffModel>>> getStaffs() {
                return staffs;
            }

            public void setStaffs(ArrayList<Map<String, ArrayList<StaffModel>>> staffs) {
                this.staffs = staffs;
            }
            private ArrayList<String> departments;
            @SerializedName("staffs")
            private ArrayList<Map<String, ArrayList<StaffModel>>> staffs;


        }

    }

}
