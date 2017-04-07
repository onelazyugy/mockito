package com.le.viet.mockito.model;

/**
 * Created by onelazyguy on 4/6/17.
 */
public class PasswordResponse {
    private PasswordRequest passwordRequest;
    private String message;
    private int statusCd;

    public PasswordRequest getPasswordRequest() {
        return passwordRequest;
    }

    public void setPasswordRequest(PasswordRequest passwordRequest) {
        this.passwordRequest = passwordRequest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(int statusCd) {
        this.statusCd = statusCd;
    }

    @Override
    public String toString() {
        return "PasswordResponse{" +
                "passwordRequest=" + passwordRequest +
                ", message='" + message + '\'' +
                ", statusCd=" + statusCd +
                '}';
    }
}
