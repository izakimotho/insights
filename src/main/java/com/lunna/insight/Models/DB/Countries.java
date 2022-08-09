package com.lunna.insight.Models.DB;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "core")
@Table(name = "Countries")


public class Countries implements java.io.Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
             strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "pg-uuid")


    @Column(name = "Country_ID", unique = true,updatable = false, nullable = false)
    private UUID cntryId;

    @Column(name = "Status", nullable = false)
    private boolean status;

    @Column(name = "Country_Code",  nullable = false, length = 50)
    private String cntryCode;


    @Column(name = "Country_Name",  nullable = false, length = 50)
    private String cntryName;

    @Column(name = "Country_Phone_Code", nullable = true , length = 50)
    private String cntryPhoneCode;


    @Column(name = "Currency_Symbol",  nullable = false, length = 50)
    private String cntrySymbol;

    @Column(name = "Currency",  nullable = false, length = 50)
    private String cntryCurrency;

    @Column(name = "Currency_Code",  nullable = false, length = 50)
    private String currencyCode;



    //    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mmCountries")
//    private Set<MdCountryCities> mdCountryCitieses = new HashSet<MdCountryCities>(0);


    public Countries() {
    }

    public Countries(UUID cntryId) {
        this.cntryId = cntryId;
    }

    public Countries(UUID cntryId, boolean status) {
        this.cntryId = cntryId;
        this.status = status;
    }

    public Countries(boolean status, String cntryCode, String cntryName, String cntryPhoneCode, String cntrySymbol, String cntryCurrency, String currencyCode) {
        this.status = status;
        this.cntryCode = cntryCode;
        this.cntryName = cntryName;
        this.cntryPhoneCode = cntryPhoneCode;
        this.cntrySymbol = cntrySymbol;
        this.cntryCurrency = cntryCurrency;
        this.currencyCode = currencyCode;
    }

    public UUID getCntryId() {
        return cntryId;
    }

    public void setCntryId(UUID cntryId) {
        this.cntryId = cntryId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCntryCode() {
        return cntryCode;
    }

    public void setCntryCode(String cntryCode) {
        this.cntryCode = cntryCode;
    }

    public String getCntryName() {
        return cntryName;
    }

    public void setCntryName(String cntryName) {
        this.cntryName = cntryName;
    }

    public String getCntryPhoneCode() {
        return cntryPhoneCode;
    }

    public void setCntryPhoneCode(String cntryPhoneCode) {
        this.cntryPhoneCode = cntryPhoneCode;
    }

    public String getCntrySymbol() {
        return cntrySymbol;
    }

    public void setCntrySymbol(String cntrySymbol) {
        this.cntrySymbol = cntrySymbol;
    }

    public String getCntryCurrency() {
        return cntryCurrency;
    }

    public void setCntryCurrency(String cntryCurrency) {
        this.cntryCurrency = cntryCurrency;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
//    public Set<MdCountryCities> getMdCountryCitieses() {
//        return this.mdCountryCitieses;
//    }
//
//    public void setMdCountryCitieses(Set<MdCountryCities> mdCountryCitieses) {
//        this.mdCountryCitieses = mdCountryCitieses;
//    }
 
}


