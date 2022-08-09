
package com.lunna.insight.Models.DTO.Common;

import java.util.UUID;

public class Country {
    private UUID id ;
    private String name = "";
    private String code = "";
    private boolean active = false;
    private String country_phone_code;
    private String currency_symbol;
    private String currency;
    public Country() {
    }

    public Country(UUID id) {
        this.id = id;
    }

    public Country(UUID id, String name, String code, boolean active) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.active = active;
    }

    public Country(UUID id, String name, String code, boolean active, String country_phone_code, String currency_symbol, String currency) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.active = active;
        this.country_phone_code = country_phone_code;
        this.currency_symbol = currency_symbol;
        this.currency = currency;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCountry_phone_code() {
        return country_phone_code;
    }

    public void setCountry_phone_code(String country_phone_code) {
        this.country_phone_code = country_phone_code;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
