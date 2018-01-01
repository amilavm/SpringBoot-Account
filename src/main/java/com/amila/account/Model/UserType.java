package com.amila.account.Model;

public enum UserType {

    CANDIDATE("CANDIDATE"),
    COMPANY("COMPANY"),
    ADMIN("ADMIN");

    String userType;


    UserType(String candidate) {

    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
