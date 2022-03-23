package com.nitolniloygroup.nngtrainingsession.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginTraining implements Serializable {

    @SerializedName("ID")
    @Expose
    private String id;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("EmpID")
    @Expose
    private String empID;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Dept")
    @Expose
    private String dept;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("EntryDate")
    @Expose
    private String entryDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

}
