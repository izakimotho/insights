package com.lunna.insight.Models.DTO.Common;


import java.util.Date;

public class CommonInfo {
    private int tenantId;
    private int userId;
    private String userIp;
    private Date userDate;


    public CommonInfo() {
    }

    public CommonInfo(int tenantId, int userId, String userIp, Date userDate) {
        this.tenantId = tenantId;
        this.userId = userId;
        this.userIp = userIp;
        this.userDate = userDate;
    }

    public CommonInfo(int tenantId) {
        this.tenantId = tenantId;
    }

    public CommonInfo(int tenantId, String userIp) {
        this.tenantId = tenantId;
        this.userIp = userIp;
    }

    public CommonInfo(String userIp) {
        this.userIp = userIp;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }
}
