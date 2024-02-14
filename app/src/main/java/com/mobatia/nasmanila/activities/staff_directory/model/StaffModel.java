package com.mobatia.nasmanila.activities.staff_directory.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by gayatri on 17/3/17.
 */
public class StaffModel {
    private String id;
    private String category_name;
    private String staffId;
    private String staffDepartment;
    private String name;
    private String staffPhoneNo;
    private String staffEmail;
    private String staffContactNo;
    private String staffAbout;
    private String staff_photo;
private String role;
    private ArrayList<StaffModel> Principal;
    private ArrayList<StaffModel> Admissions;

    public ArrayList<StaffModel> getPrincipal() {
        return Principal;
    }

    public void setPrincipal(ArrayList<StaffModel> principal) {
        Principal = principal;
    }

    public ArrayList<StaffModel> getAdmissions() {
        return Admissions;
    }

    public void setAdmissions(ArrayList<StaffModel> admissions) {
        Admissions = admissions;
    }

    public ArrayList<StaffModel> getMarketing() {
        return Marketing;
    }

    public void setMarketing(ArrayList<StaffModel> marketing) {
        Marketing = marketing;
    }

    public ArrayList<StaffModel> getFinance() {
        return Finance;
    }

    public void setFinance(ArrayList<StaffModel> finance) {
        Finance = finance;
    }

    public ArrayList<StaffModel> getHumanResource() {
        return HumanResource;
    }

    public void setHumanResource(ArrayList<StaffModel> humanResource) {
        HumanResource = humanResource;
    }

    public ArrayList<StaffModel> getICT() {
        return ICT;
    }

    public void setICT(ArrayList<StaffModel> ICT) {
        this.ICT = ICT;
    }

    public ArrayList<StaffModel> getOperations() {
        return Operations;
    }

    public void setOperations(ArrayList<StaffModel> operations) {
        Operations = operations;
    }

    public ArrayList<StaffModel> getAdministration() {
        return Administration;
    }

    public void setAdministration(ArrayList<StaffModel> administration) {
        Administration = administration;
    }

    private ArrayList<StaffModel> Marketing;
    private ArrayList<StaffModel> Finance;
    @SerializedName("Human Resource")


    private ArrayList<StaffModel> HumanResource;
    private ArrayList<StaffModel> ICT;
    private ArrayList<StaffModel> Operations;
    private ArrayList<StaffModel> Administration
            ;

    public String getStaffCategoryId() {
        return id;
    }

    public void setStaffCategoryId(String staffCategoryId) {
        this.id = staffCategoryId;
    }

    public String getStaffCategoryName() {
        return category_name;
    }

    public void setStaffCategoryName(String staffCategoryName) {
        this.category_name = staffCategoryName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public String getStaffName() {
        return name;
    }

    public void setStaffName(String staffName) {
        this.name = staffName;
    }

    public String getStaffPhoneNo() {
        return staffPhoneNo;
    }

    public void setStaffPhoneNo(String staffPhoneNo) {
        this.staffPhoneNo = staffPhoneNo;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffContactNo() {
        return staffContactNo;
    }

    public void setStaffContactNo(String staffContactNo) {
        this.staffContactNo = staffContactNo;
    }

    public String getStaffAbout() {
        return staffAbout;
    }

    public void setStaffAbout(String staffAbout) {
        this.staffAbout = staffAbout;
    }

    public String getStaffImage() {
        return staff_photo;
    }

    public void setStaffImage(String staffImage) {
        this.staff_photo = staffImage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
