package com.example.Vending_Machine.util;

public enum UserRoles {
    BUYER("buyer");

    private String status;
    public String getStatus() {
        return status;
    }
    public String value() {return status; }
    public void setStatus(String status) {
        this.status = status;
    }

    private UserRoles(String status) {
        this.status = status;
    }

}
