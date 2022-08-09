package com.lunna.insight.Models.DB.Profile;


import com.lunna.insight.Models.DB.MmEntity;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "MM_Users"
)
public class MmUsers implements java.io.Serializable {


    private int usrId;
    private MmEntity mmEntity;
    private String usrFullName;
    private String usrName;
    private String usrPassword;
    private String usrEmail;
    private String usrMobile;
    private String usrImage;
    private String usrImageThumb;
    private String usrAccessToken;
    private String usrPayrollNumber;
    private int usrMaxLogin;
    private boolean isDefault;
    private boolean status;
    private boolean usrChangePasswordNextLogon;
    private boolean authorizationStatus;
    private boolean rejectionStatus;
    private int uploaded;
    private Date usrExpiry; 

    public MmUsers() {
    }

    public MmUsers(int usrId) {
        this.usrId = usrId;
    }

    public MmUsers(int usrId,  boolean isDefault, boolean status, boolean usrChangePasswordNextLogon, boolean authorizationStatus, int uploaded) {
        this.usrId = usrId;
       
        this.mmEntity = mmEntity;
       
        this.isDefault = isDefault;
        this.status = status;
        this.usrChangePasswordNextLogon = usrChangePasswordNextLogon;
        this.authorizationStatus = authorizationStatus;
        this.uploaded = uploaded;
    }

    public MmUsers(int usrId,  MmEntity mmEntity,  String usrFullName, String usrName, String usrPassword, String usrEmail, String usrMobile, String usrImage, String usrImageThumb, String usrAccessToken, String usrPayrollNumber, boolean isDefault, boolean status, boolean usrChangePasswordNextLogon, boolean authorizationStatus, int uploaded, Date usrExpiry
                 ) {
        this.usrId = usrId;
        this.mmEntity = mmEntity;
       
        this.usrFullName = usrFullName;
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.usrEmail = usrEmail;
        this.usrMobile = usrMobile;
        this.usrImage = usrImage;
        this.usrImageThumb = usrImageThumb;
        this.usrAccessToken = usrAccessToken;
        this.usrPayrollNumber = usrPayrollNumber;
        this.usrChangePasswordNextLogon = usrChangePasswordNextLogon;
        this.usrExpiry = usrExpiry;
        this.isDefault = isDefault;
        this.authorizationStatus = authorizationStatus;
        this.uploaded = uploaded;
        this.status = status;
    }


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "pg-uuid")

    @Column(name = "Usr_ID", unique = true, nullable = false)
    public int getUsrId() {
        return this.usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Tenant_Ent_ID", nullable = false)
    public MmEntity getMmEntity() {
        return this.mmEntity;
    }

    public void setMmEntity(MmEntity mmEntity) {
        this.mmEntity = mmEntity;
    }


    @Column(name = "Usr_Full_Name", length = 256)
    public String getUsrFullName() {
        return this.usrFullName;
    }

    public void setUsrFullName(String usrFullName) {
        this.usrFullName = usrFullName;
    }


    @Column(name = "Usr_Name", length = 50)
    public String getUsrName() {
        return this.usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }


    @Column(name = "Usr_Password", length = 256)
    public String getUsrPassword() {
        return this.usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }


    @Column(name = "Usr_Email", length = 256)
    public String getUsrEmail() {
        return this.usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }


    @Column(name = "Usr_Mobile", length = 256)
    public String getUsrMobile() {
        return this.usrMobile;
    }

    public void setUsrMobile(String usrMobile) {
        this.usrMobile = usrMobile;
    }


    @Column(name = "Usr_Image", length = 200)
    public String getUsrImage() {
        return this.usrImage;
    }

    public void setUsrImage(String usrImage) {
        this.usrImage = usrImage;
    }


    @Column(name = "Usr_Image_Thumb", length = 200)
    public String getUsrImageThumb() {
        return this.usrImageThumb;
    }

    public void setUsrImageThumb(String usrImageThumb) {
        this.usrImageThumb = usrImageThumb;
    }


    @Column(name = "Usr_Access_Token", length = 100)
    public String getUsrAccessToken() {
        return this.usrAccessToken;
    }

    public void setUsrAccessToken(String usrAccessToken) {
        this.usrAccessToken = usrAccessToken;
    }


    @Column(name = "Usr_Payroll_Number", length = 100)
    public String getUsrPayrollNumber() {
        return this.usrPayrollNumber;
    }

    public void setUsrPayrollNumber(String usrPayrollNumber) {
        this.usrPayrollNumber = usrPayrollNumber;
    }


    @Column(name = "Is_Default", nullable = false)
    public boolean isIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Column(name = "Usr_Max_Login", nullable = false)
    public int getUsrMaxLogin() {
        return this.usrMaxLogin;
    }

    public void setUsrMaxLogin(int usrMaxLogin) {
        this.usrMaxLogin = usrMaxLogin;
    }


    @Column(name = "Status", nullable = false)
    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Column(name = "Usr_change_password_NextLogon", nullable = false)
    public boolean isUsrChangePasswordNextLogon() {
        return this.usrChangePasswordNextLogon;
    }

    public void setUsrChangePasswordNextLogon(boolean usrChangePasswordNextLogon) {
        this.usrChangePasswordNextLogon = usrChangePasswordNextLogon;
    }


    @Column(name = "Authorization_Status", nullable = false)
    public boolean isAuthorizationStatus() {
        return this.authorizationStatus;
    }

    public void setAuthorizationStatus(boolean authorizationStatus) {
        this.authorizationStatus = authorizationStatus;
    }


    @Column(name = "Uploaded", nullable = false)
    public int getUploaded() {
        return this.uploaded;
    }

    public void setUploaded(int uploaded) {
        this.uploaded = uploaded;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Usr_Expiry", length = 23)
    public Date getUsrExpiry() {
        return this.usrExpiry;
    }

    public void setUsrExpiry(Date usrExpiry) {
        this.usrExpiry = usrExpiry;
    }


    @Column(name = "Rejection_Status", nullable = false)
    public boolean isRejectionStatus() {
        return rejectionStatus;
    }
    public void setRejectionStatus(boolean rejectionStatus) {
        this.rejectionStatus = rejectionStatus;
    }
}
