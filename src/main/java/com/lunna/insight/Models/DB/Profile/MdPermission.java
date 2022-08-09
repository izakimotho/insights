package com.lunna.insight.Models.DB.Profile;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "MD_Permission"

)
public class MdPermission implements java.io.Serializable {


    private int permissionId;
    private MdResource mdResource;
    private String code;
    private byte type;
    private boolean status;


    public MdPermission() {
    }


    public MdPermission(int permissionId, MdResource mdResource, String code, byte type, boolean status) {
        this.permissionId = permissionId;
        this.mdResource = mdResource;
        this.code = code;
        this.type = type;
        this.status = status;
    }



    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "pg-uuid")

    @Column(name = "Permission_ID", unique = true, nullable = false)
    public int getPermissionId() {
        return this.permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Resource_ID", nullable = false)
    public MdResource getMdResource() {
        return this.mdResource;
    }

    public void setMdResource(MdResource mdResource) {
        this.mdResource = mdResource;
    }


    @Column(name = "Code", nullable = false, length = 50)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Column(name = "Type", nullable = false)
    public byte getType() {
        return this.type;
    }

    public void setType(byte type) {
        this.type = type;
    }


    @Column(name = "Status", nullable = false)
    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}

