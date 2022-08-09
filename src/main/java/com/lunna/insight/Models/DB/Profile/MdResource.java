package com.lunna.insight.Models.DB.Profile;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "coreMerchandising")
@Table(name = "MD_Resource"

)
public class MdResource implements java.io.Serializable {


    private int resourceId;
    private MmModule mmModule;
    private String code;
    private String resourceType;
    private boolean status;
    private Set<MdPermission> mdPermissions = new HashSet<MdPermission>(0);

    public MdResource() {
    }


    public MdResource(int resourceId, MmModule mmModule, String code, String resourceType, boolean status) {
        this.resourceId = resourceId;
        this.mmModule = mmModule;
        this.code = code;
        this.resourceType = resourceType;
        this.status = status;
    }

    public MdResource(int resourceId, MmModule mmModule, String code, String resourceType, boolean status,   Set<MdPermission> mdPermissions) {
        this.resourceId = resourceId;
        this.mmModule = mmModule;
        this.code = code;
        this.resourceType = resourceType;
        this.status = status;
        this.mdPermissions = mdPermissions;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "pg-uuid")

    @Column(name = "Resource_ID", unique = true, nullable = false)
    public int getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Module_ID", nullable = false)
    public MmModule getMmModule() {
        return this.mmModule;
    }

    public void setMmModule(MmModule mmModule) {
        this.mmModule = mmModule;
    }


    @Column(name = "Code", nullable = false, length = 50)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Column(name = "Resource_Type", nullable = false, length = 50)
    public String getResourceType() {
        return this.resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }


    @Column(name = "Status", nullable = false)
    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }




    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mdResource")
    public Set<MdPermission> getMdPermissions() {
        return this.mdPermissions;
    }

    public void setMdPermissions(Set<MdPermission> mdPermissions) {
        this.mdPermissions = mdPermissions;
    }


}


