package com.lunna.insight.Models.DTO.Profile;


public class UserLogin {

    private String userName;
    private String password;
    private String type;//Could be biometric or password, password login is assumed by default
    private String stringFingerprint;//base64 representation of user's fingerprint
    private boolean isFirstUser;
    private String reason;

    public UserLogin() {
        type = "password";
    }

    public UserLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStringFingerprint() {
        return stringFingerprint;
    }

    public void setStringFingerprint(String stringFingerprint) {
        this.stringFingerprint = stringFingerprint;
    }

    public boolean isFirstUser() {
        return isFirstUser;
    }

    public void setFirstUser(boolean firstUser) {
        isFirstUser = firstUser;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
