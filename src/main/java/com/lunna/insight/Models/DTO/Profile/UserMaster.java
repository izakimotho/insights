package com.lunna.insight.Models.DTO.Profile;

import com.lunna.insight.Models.DTO.Common.Image;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserMaster {
    private int id = 0;
    private Integer workFlowId;
    private String email = "";
    private String fullName = "";
    private String payrollNumber = "";
    private String phone = "";
    private String username = "";
    private String password = "";
    private String token = "";
    private boolean active = true;
    private boolean authStatus;
    private String confirmPassword = "";
    private Image image;
    private String usrImage;
    private String usrThumbImage;
    private int maxLogin;
    private boolean isGeneratedPassword;
    private boolean nextLoginChangePassword;
    private Date expiryDate;
    private boolean expiry;
    private boolean hasRegsteredFingerprints;
    private boolean changeOrNotification;// true = Change / false = Notification
    private List<Roles> roles = new ArrayList<>();

    public UserMaster() {
    }

    public UserMaster(int id, String email, String fullName,
                      String payrollNumber, String phone, List<Roles> roles,
                      String username, String password, String token, boolean active,
                      String confirmPassword, Image image, boolean generatedPassword,
                      boolean nextLoginChangePassword, String usrImage,
                      String usrThumbImage) {
        super();
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.payrollNumber = payrollNumber;
        this.phone = phone;
        this.roles = roles;
        this.username = username;
        this.password = password;
        this.token = token;
        this.active = active;
        this.confirmPassword = confirmPassword;
        this.image = image;
        this.isGeneratedPassword = generatedPassword;
        this.nextLoginChangePassword = nextLoginChangePassword;
        this.usrImage = usrImage;
        this.usrThumbImage = usrThumbImage;
    }

    public int getMaxLogin() {
        return maxLogin;
    }

    public void setMaxLogin(int maxLogin) {
        this.maxLogin = maxLogin;
    }

    public String getUsrImage() {
        return usrImage;
    }

    public void setUsrImage(String usrImage) {
        this.usrImage = usrImage;
    }

    public String getUsrThumbImage() {
        return usrThumbImage;
    }

    public void setUsrThumbImage(String usrThumbImage) {
        this.usrThumbImage = usrThumbImage;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isGeneratedPassword() {
        return isGeneratedPassword;
    }

    public void setGeneratedPassword(boolean generatedPassword) {
        isGeneratedPassword = generatedPassword;
    }

    public boolean isHasRegsteredFingerprints() {
        return hasRegsteredFingerprints;
    }

    public void setHasRegsteredFingerprints(boolean hasRegsteredFingerprints) {
        this.hasRegsteredFingerprints = hasRegsteredFingerprints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPayrollNumber() {
        return payrollNumber;
    }

    public void setPayrollNumber(String payrollNumber) {
        this.payrollNumber = payrollNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }



    public boolean isIsGeneratedPassword() {
        return isGeneratedPassword;
    }

    public void setIsGeneratedPassword(boolean generatedPassword) {
        this.isGeneratedPassword = generatedPassword;
    }

    public boolean isNextLoginChangePassword() {
        return nextLoginChangePassword;
    }

    public void setNextLoginChangePassword(boolean nextLoginChangePassword) {
        this.nextLoginChangePassword = nextLoginChangePassword;
    }

    public Integer getWorkFlowId() {
        return workFlowId;
    }

    public void setWorkFlowId(Integer workFlowId) {
        this.workFlowId = workFlowId;
    }

    public boolean isAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(boolean authStatus) {
        this.authStatus = authStatus;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpiry() {
        return expiry;
    }

    public void setExpiry(boolean expiry) {
        this.expiry = expiry;
    }

    public boolean isChangeOrNotification() {
        return changeOrNotification;
    }

    public void setChangeOrNotification(boolean changeOrNotification) {
        this.changeOrNotification = changeOrNotification;
    }

}
