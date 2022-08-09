package com.lunna.insight.Models.Common;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "MM_Gender"
)
public class MmGender implements java.io.Serializable {

    private int genderId;
    private String genderCode;
    private Boolean status;
    public MmGender() {
    }

    public MmGender(int genderId) {
        this.genderId = genderId;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "pg-uuid")
    @Column(name = "Gender_ID", unique = true, nullable = false)
    public int getGenderId() {
        return this.genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    @Column(name = "Gender_Code", nullable = false)
    public String getGenderCode() {
        return this.genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }



    @Column(name = "Status")
    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
