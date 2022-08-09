package com.lunna.insight.Models.DTO.Profile;

import com.lunna.insight.Models.DTO.Common.Entity;

public class LoginAction {

    private String message;
    private boolean success;
    private int state;
    private String fullName;
    private String userName;
    private String role;
    private String picture;
    private int id;
    private String token;
    private boolean nextLoginChangePassword;
    private Entity tenantEntity;
    private AuthorizationDetails authorizations;


    public LoginAction() {

    }
    public LoginAction(String message, boolean success, String fullName, String userName, String role, String picture, int id, String token,   boolean nextLoginChangePassword,  Entity tenantEntity, int state) {
        this.message = message;
        this.success = success;
        this.fullName = fullName;
        this.userName = userName;
        this.role = role;
        this.picture = picture;
        this.id = id;
        this.token = token;
        this.nextLoginChangePassword = nextLoginChangePassword;
        this.tenantEntity = tenantEntity;
        this.state = state;
    }



    public LoginAction(String message, boolean success, int state) {
        this.message = message;
        this.success = success;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Entity getTenantEntity() {
        return tenantEntity;
    }

    public void setTenantEntity(Entity tenantEntity) {
        this.tenantEntity = tenantEntity;
    }


    public boolean isNextLoginChangePassword() {
        return nextLoginChangePassword;
    }

    public void setNextLoginChangePassword(boolean nextLoginChangePassword) {
        this.nextLoginChangePassword = nextLoginChangePassword;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthorizationDetails getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(AuthorizationDetails authorizations) {
        this.authorizations = authorizations;
    }

}
