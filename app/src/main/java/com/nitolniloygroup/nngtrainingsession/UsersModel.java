package com.nitolniloygroup.nngtrainingsession;

import java.io.Serializable;
import java.util.List;

public class UsersModel implements Serializable {
    List<UserModel> users;

    public UsersModel() {
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
