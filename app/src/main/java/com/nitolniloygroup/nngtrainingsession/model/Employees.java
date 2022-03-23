
package com.nitolniloygroup.nngtrainingsession.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Employees implements Serializable {

    @SerializedName("HttpStatusCode")
    @Expose
    private Integer httpStatusCode;
    @SerializedName("Msg")
    @Expose
    private String msg;
    @SerializedName("Success")
    @Expose
    private Boolean success;
    @SerializedName("LoginTraining")
    @Expose
    private List<LoginTraining> loginTraining = null;

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<LoginTraining> getLoginTraining() {
        return loginTraining;
    }

    public void setLoginTraining(List<LoginTraining> loginTraining) {
        this.loginTraining = loginTraining;
    }

}
