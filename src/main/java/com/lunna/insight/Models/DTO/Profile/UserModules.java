package com.lunna.insight.Models.DTO.Profile;

 
public class UserModules {
    private String modules;
    private boolean success;
    private String message;

    public UserModules() {
    }

    public UserModules(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public UserModules(String modules, boolean success) {
        this.modules = modules;
        this.success = success;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
