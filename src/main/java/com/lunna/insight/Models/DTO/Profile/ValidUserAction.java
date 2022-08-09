package com.lunna.insight.Models.DTO.Profile;


public class ValidUserAction {

    private boolean status;
    private String responseMessage;
    private String userName;
    private String userImage;
    private String loginMode;
    private int state;

    public ValidUserAction(String responseMessage, boolean status, int state) {
        this.status = status;
        this.responseMessage = responseMessage;
        this.state = state;
    }

    public ValidUserAction() {
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(String loginMode) {
        this.loginMode = loginMode;
    }
}