package com.lunna.insight.Core.security.session.license;

import java.util.List;


public class LicenseVerification {
    private List<LicenseModules> modules;
    private String hashKey;

    public LicenseVerification() {
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public List<LicenseModules> getModules() {
        return modules;
    }

    public void setModules(List<LicenseModules> modules) {
        this.modules = modules;
    }
}
