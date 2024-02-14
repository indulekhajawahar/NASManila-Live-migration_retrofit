package com.mobatia.nasmanila.retrofit;

import com.mobatia.nasmanila.activities.staff_directory.model.StaffModel;

import java.util.ArrayList;

public class Categori {
    public Categori(String departmentName, ArrayList<StaffModel> staffList) {
        this.departmentName = departmentName;
        this.staffList = staffList;
    }

    String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public ArrayList<StaffModel> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<StaffModel> staffList) {
        this.staffList = staffList;
    }

    ArrayList<StaffModel> staffList;
}
