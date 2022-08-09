package com.lunna.insight.Models.DTO.Common;

import java.util.List;

public class Entity {

    private int entity_id = 0;
    private String name = "";
    private BaseCurrency baseCurrency = new BaseCurrency();
    private boolean active = false;
    private int structId;
    private String domainName;

    private List<Image> images;


    public Entity(int entity_id, boolean active, String domainName) {
        this.entity_id = entity_id;
        this.active = active;
        this.domainName = domainName;
    }

    public Entity() {
    }

    public Entity(int entity_id, String name, BaseCurrency baseCurrency, boolean active, String domainName) {
        this.entity_id = entity_id;
        this.name = name;
        this.baseCurrency = baseCurrency;
        this.active = active;
        this.domainName = domainName;
    }

    public Entity(int entity_id) {
        this.entity_id = entity_id;
    }

    public int getId() {
        return entity_id;
    }

    public void setId(int entity_id) {
        this.entity_id = entity_id;
    }

    public BaseCurrency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(BaseCurrency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getStructId() {
        return structId;
    }

    public void setStructId(int structId) {
        this.structId = structId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public static class BaseCurrency {

        private int id = 0;
        private String code = "";
        private String name = "";

        public BaseCurrency() {
        }

        public BaseCurrency(int id) {
            this.id = id;
        }

        public BaseCurrency(int id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String baseCurrencyCode) {
            this.code = baseCurrencyCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String baseCurrencyName) {
            this.name = baseCurrencyName;
        }
    }
}
