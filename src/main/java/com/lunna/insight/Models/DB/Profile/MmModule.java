package com.lunna.insight.Models.DB.Profile;


import com.lunna.insight.Models.DB.MmEntity;
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
@Table(name = "MM_Module"
)
public class MmModule implements java.io.Serializable {


    private int moduleId;
    private MmEntity mmEntity;
    private boolean status;
    private boolean role;
    private boolean authorizationStatus;
    private boolean rejectionStatus;
    private String moduleSysCode;
    private String moduleName;
    private String description;
    private Set<MdUserRoles> mdUserRoleses = new HashSet<MdUserRoles>(0);
    private Set<MdResource> mdResources = new HashSet<MdResource>(0);

    public MmModule() {
    }

    public MmModule(int moduleId) {
        this.moduleId = moduleId;
    }

    public MmModule(int moduleId, boolean status, boolean role, boolean authorizationStatus) {
        this.moduleId = moduleId;
        this.status = status;
        this.role = role;
        this.authorizationStatus = authorizationStatus;
    }

    public MmModule(int moduleId, MmEntity mmEntity, boolean status, boolean role, boolean authorizationStatus, boolean rejectionStatus, String moduleSysCode, String moduleName, String description, Set<MdUserRoles> mdUserRoleses, Set<MdResource> mdResources) {
        this.moduleId = moduleId;
        this.mmEntity = mmEntity;
        this.status = status;
        this.role = role;
        this.authorizationStatus = authorizationStatus;
        this.rejectionStatus = rejectionStatus;
        this.moduleSysCode = moduleSysCode;
        this.moduleName = moduleName;
        this.description = description;
        this.mdUserRoleses = mdUserRoleses;
        this.mdResources = mdResources;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "pg-uuid")

    @Column(name = "Module_ID", unique = true, nullable = false)
    public int getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Tenant_Ent_ID")
    public MmEntity getMmEntity() {
        return this.mmEntity;
    }

    public void setMmEntity(MmEntity mmEntity) {
        this.mmEntity = mmEntity;
    }


    @Column(name = "Status", nullable = false)
    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    @Column(name = "module_name", nullable = false)
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "Role", nullable = false)
    public boolean isRole() {
        return this.role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }


    @Column(name = "Authorization_Status", nullable = false)
    public boolean isAuthorizationStatus() {
        return this.authorizationStatus;
    }

    public void setAuthorizationStatus(boolean authorizationStatus) {
        this.authorizationStatus = authorizationStatus;
    }


    @Column(name = "Module_Sys_Code", length = 20)
    public String getModuleSysCode() {
        return this.moduleSysCode;
    }

    public void setModuleSysCode(String moduleSysCode) {
        this.moduleSysCode = moduleSysCode;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mmModule")
    public Set<MdUserRoles> getMdUserRoleses() {
        return this.mdUserRoleses;
    }

    public void setMdUserRoleses(Set<MdUserRoles> mdUserRoleses) {
        this.mdUserRoleses = mdUserRoleses;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mmModule")
    public Set<MdResource> getMdResources() {
        return this.mdResources;
    }

    public void setMdResources(Set<MdResource> mdResources) {
        this.mdResources = mdResources;
    }



    @Column(name = "rejection_status", nullable = false)
    public boolean isRejectionStatus() {
        return rejectionStatus;
    }

    public void setRejectionStatus(boolean rejectionStatus) {
        this.rejectionStatus = rejectionStatus;
    }

}
