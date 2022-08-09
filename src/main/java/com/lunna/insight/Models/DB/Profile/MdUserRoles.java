package com.lunna.insight.Models.DB.Profile;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "MD_User_Roles"

)
public class MdUserRoles implements java.io.Serializable {


    private int usrRoleId;
    private MmModule mmModule;
    private MmUsers mmUsers;
    private int uploaded;

    public MdUserRoles() {
    }

    public MdUserRoles(MmModule mmModule, MmUsers mmUsers) {
        this.mmModule = mmModule;
        this.mmUsers = mmUsers;
    }

    public MdUserRoles(int usrRoleId, MmModule mmModule, MmUsers mmUsers, int uploaded) {
        this.usrRoleId = usrRoleId;
        this.mmModule = mmModule;
        this.mmUsers = mmUsers;
        this.uploaded = uploaded;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "pg-uuid")

    @Column(name = "Usr_Role_ID", unique = true, nullable = false)
    public int getUsrRoleId() {
        return this.usrRoleId;
    }

    public void setUsrRoleId(int usrRoleId) {
        this.usrRoleId = usrRoleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Role_ID", nullable = false)
    public MmModule getMmModule() {
        return this.mmModule;
    }

    public void setMmModule(MmModule mmModule) {
        this.mmModule = mmModule;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Usr_ID", nullable = false)
    public MmUsers getMmUsers() {
        return this.mmUsers;
    }

    public void setMmUsers(MmUsers mmUsers) {
        this.mmUsers = mmUsers;
    }


    @Column(name = "Uploaded", nullable = false)
    public int getUploaded() {
        return this.uploaded;
    }

    public void setUploaded(int uploaded) {
        this.uploaded = uploaded;
    }


}



