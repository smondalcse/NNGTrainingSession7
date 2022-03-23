package com.nitolniloygroup.nngtrainingsession;

import java.io.Serializable;

public class UserModel implements Serializable {
    String EmpID, EmpName, EmpMobile;

    public UserModel() {
    }

    public UserModel(String empID, String empName, String empMobile) {
        EmpID = empID;
        EmpName = empName;
        EmpMobile = empMobile;
    }

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String empID) {
        EmpID = empID;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public String getEmpMobile() {
        return EmpMobile;
    }

    public void setEmpMobile(String empMobile) {
        EmpMobile = empMobile;
    }
}
