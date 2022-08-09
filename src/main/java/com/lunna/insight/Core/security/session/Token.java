
package com.lunna.insight.Core.security.session;

public class Token {
    private int userId = 0;
    private int currentModuleId = 0;
    private String entLicense = "";
    private long expiresAfter = 3600000 * 5; // One Hour * 5
    //    private long expiresAfter = ((1000 * 15) * 60) * 2; // Two minutes - Duration has to be in multiples of 15000 (millis)
    /*private long expiresAfter = 60000; // Two minutes - Duration has to be in multiples of 15000 (millis)*/
    /*private long expiresAfter = ((1000 * 15) * 60) * 180; //Three Hours*/
    private String value = "";
    private RemoveAction removeAction;
    private String domainName = "";
    private int entId = 0;

    public Token(int userId, String value, RemoveAction removeAction, int currentModuleId, String entLicense, String domainName, int entId) {
        this.userId = userId;
        this.value = value;
        this.removeAction = removeAction;
        this.currentModuleId = currentModuleId;
        this.entLicense = entLicense;
        this.domainName = domainName;
        this.entId = entId;
    }

    public Token(int userId, String value, long expiresAfter, RemoveAction removeAction, int currentModuleId, String entLicense, String domainName, int entId) {
        this.userId = userId;
        this.value = value;
        this.expiresAfter = expiresAfter;
        this.removeAction = removeAction;
        this.currentModuleId = currentModuleId;
        this.entLicense = entLicense;
        this.domainName = domainName;
        this.entId = entId;
    }

    public String getDomainName() {
        return domainName;
    }

    public int getEntId() {
        return entId;
    }

    String getEntLicense() {
        return entLicense;
    }

    int getCurrentModuleId() {
        return currentModuleId;
    }

    public void setCurrentModuleId(int currentModuleId) {
        this.currentModuleId = currentModuleId;
    }

    RemoveAction getRemoveAction() {
        return removeAction;
    }

    public int getUserId() {
        return userId;
    }

    public long getExpiresAfter() {
        return expiresAfter;
    }

    public String getValue() {
        return value;
    }

    /*
    * This will always be called all the times assuming the account has no activity
    * If expiresAfter gets to 0, when there is no renewal, an inhouse clean up thread will remove it
    */

    long deductExpiry(long duration) {
        if (expiresAfter > duration || expiresAfter == duration) {
            expiresAfter = expiresAfter - duration;
        } else if (expiresAfter < duration) {
            expiresAfter = 0;
        }
        return expiresAfter;
    }
}
