package com.lunna.insight.Core.security.session.license;


public class LicenseModules {
    private int moduleId;
    private int userCount;

    public LicenseModules() {
    }


    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
}
