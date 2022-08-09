package com.lunna.insight.Models.DTO.Common;

public class ModuleChange {
    private int toModule;
    private String key;

    public ModuleChange() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getToModule() {
        return toModule;
    }

    public void setToModule(int toModule) {
        this.toModule = toModule;
    }
}
