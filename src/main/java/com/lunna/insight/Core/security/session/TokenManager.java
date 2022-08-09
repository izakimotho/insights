

package com.lunna.insight.Core.security.session;


import com.lunna.insight.Core.security.AES;
import com.lunna.insight.Core.security.session.license.LicenseModules;
import com.lunna.insight.Core.security.session.license.LicenseVerification;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


@SuppressWarnings("LoopStatementThatDoesntLoop")
public class TokenManager {
    private static boolean tokenManagerRunning = false;
    private static TokenStore tokenStore = TokenStore.getInstance();
    private List<LicenseVerification> licenseVerificationList;

    private TokenManager() {
    }

    public static TokenManager getInstance() {
        startTokenManager();
        return TokenManagerHolder.INSTANCE;
    }

    private static boolean startTokenManager() {
        if (!tokenManagerRunning) {
            tokenManagerRunning = true;
            TokenManagerThread tokenManagerThread = new TokenManagerThread();
            tokenManagerThread.start();
        }
        return isTokenManagerRunning();
    }

    private static boolean isTokenManagerRunning() {
        return tokenManagerRunning;
    }

    public List<LicenseVerification> getLicenseVerificationList() {
        return licenseVerificationList;
    }

    public void setLicenseVerificationList(List<LicenseVerification> licenseVerificationList) {
        this.licenseVerificationList = licenseVerificationList;
    }

    // An external interface to stop the token manager from the global Thread Manager
    public boolean stopTokenManager() {
        tokenManagerRunning = false;
        return isTokenManagerRunning();
    }

    public boolean validateToken(String value) {
        return tokenStore.getTokens().containsKey(value);
    }

    public void renewToken(Token token) throws Exception {
        if (licenseVerificationList == null || licenseVerificationList.isEmpty()) {
            throw new Exception("304-No License Information found");
        }
        for (LicenseVerification verification : licenseVerificationList) {
            if (verification.getHashKey().equals(token.getEntLicense()) && AES.validateHashKey(verification.getHashKey(), token.getEntId(), token.getDomainName())) {
                if (verification.getModules() == null || verification.getModules().isEmpty()) {
                    throw new Exception("305-No License Module Information found");
                }
                for (LicenseModules modules : verification.getModules()) {
                    if (modules.getModuleId() == token.getCurrentModuleId()) {
                        if (getLoggedInUsers(token.getCurrentModuleId(), token.getValue()) >= modules.getUserCount()) {
                            throw new Exception("306-User Count for current License Exceeded");
                        } else {
                            tokenStore.getTokens().put(token.getValue(), new Token(token.getUserId(), token.getValue(), token.getRemoveAction(), token.getCurrentModuleId(), token.getEntLicense(), token.getDomainName(), token.getEntId()));
                            return;
                        }
                    }
                }
                break;
            }
        }
        throw new Exception("307-License Invalid");
        //System.out.println("\n\n ************** Updating token's expiry for: " + value + ": **************\n\n");
    }

    public Token getToken(String key) {
        Token token = null;
        if (validateToken(key)) {
            token = tokenStore.get(key);
        }
        return token;
    }

    public Map<String, Token> getTokens() {
        return tokenStore.getTokens();
    }

    public TokenResponse allowModuleChange(ModuleChange change) throws Exception {
        Token token = getToken(change.getKey());
        if (token == null) {
            return new TokenResponse(false, "303-User Not Authorized");
        }
        if (token.getCurrentModuleId() == change.getToModule()) {
            return new TokenResponse(true, "User is Already Authorized for this Module");
        }
        if (licenseVerificationList == null || licenseVerificationList.isEmpty()) {
            return new TokenResponse(false, "304-No License Information found");
        }
        for (LicenseVerification verification : licenseVerificationList) {
            if (verification.getHashKey().equals(token.getEntLicense()) && AES.validateHashKey(verification.getHashKey(), token.getEntId(), token.getDomainName())) {
                if (verification.getModules() == null || verification.getModules().isEmpty()) {
                    return new TokenResponse(false, "305-No License Module Information found");
                }
                for (LicenseModules modules : verification.getModules()) {
                    if (modules.getModuleId() == change.getToModule()) {
                        if (getLoggedInUsers(change.getToModule(), token.getValue()) >= modules.getUserCount()) {
                            return new TokenResponse(false, "306-User Count for current License Exceeded");
                        } else {
                            tokenStore.getTokens().put(token.getValue(), new Token(token.getUserId(), token.getValue(), token.getRemoveAction(), change.getToModule(), token.getEntLicense(), token.getDomainName(), token.getEntId()));
                            return new TokenResponse(true);
                        }
                    }
                }
                break;
            }
        }
        return new TokenResponse(false, "307-License Invalid");
        //System.out.println("\n\n ************** Token: " + value + " pushed in the pool**************\n\n");
    }

    public void pushToken(Token token) throws Exception {
        if (licenseVerificationList == null || licenseVerificationList.isEmpty()) {
            throw new Exception("304-No License Information found");
        }
        for (LicenseVerification verification : licenseVerificationList) {
            if (verification.getHashKey().equals(token.getEntLicense()) && AES.validateHashKey(verification.getHashKey(), token.getEntId(), token.getDomainName())) {
                if (verification.getModules() == null || verification.getModules().isEmpty()) {
                    throw new Exception("305-No License Module Information found");
                }
                for (LicenseModules modules : verification.getModules()) {
                    if (modules.getModuleId() == token.getCurrentModuleId()) {
                        if (getLoggedInUsers(token.getCurrentModuleId(), token.getValue()) >= modules.getUserCount()) {
                            throw new Exception("306-User Count for current License Exceeded");
                        } else {
                            tokenStore.push(token.getValue(), token);
                            return;
                        }
                    }
                }
                break;
            }
        }
        throw new Exception("307-License Invalid");
        //System.out.println("\n\n ************** Token: " + value + " pushed in the pool**************\n\n");
    }

    private int getLoggedInUsers(int moduleId, String excludeToken) {
        int cntr = 0;
        Iterator iterator = tokenStore.getTokens().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Token> pair = (Map.Entry<String, Token>) iterator.next();
            Token token = pair.getValue();
            if (token.getCurrentModuleId() == moduleId && !token.getValue().equalsIgnoreCase(excludeToken)) {
                cntr++;
            }
        }
        return cntr;
    }

    private static class TokenManagerHolder {
        private static final TokenManager INSTANCE = new TokenManager();
    }

    // Deduct 15ms from all tokens once after every 15 millis
    // Remove the token from the store if it has expired
    // Duration to be made configurable from the global system settings in future
    private static class TokenManagerThread extends Thread {
        public void run() {
            while (isTokenManagerRunning()) {
                Iterator iterator = tokenStore.getTokens().entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Token> pair = (Map.Entry<String, Token>) iterator.next();
                    Token token = pair.getValue();
                    long expiresAfter = token.deductExpiry(15);
                    if (expiresAfter == 0) {
                        System.out.println("Before Removal: " + tokenStore.getTokens().size());
                        if (token.getRemoveAction() != null) {
                            token.getRemoveAction().updateLogOutTime(token.getValue());
                        }
                        iterator.remove();
                        System.out.println("After Removal: " + tokenStore.getTokens().size());
                    } else {
                        tokenStore.getTokens().put(token.getValue(), new Token(token.getUserId(), token.getValue(), expiresAfter, token.getRemoveAction(), token.getCurrentModuleId(), token.getEntLicense(), token.getDomainName(), token.getEntId()));
                    }
                }
                try {
                    sleep(15);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            Iterator iterator = tokenStore.getTokens().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Token> pair = (Map.Entry<String, Token>) iterator.next();
                Token token = pair.getValue();
                if (token.getRemoveAction() != null) {
                    token.getRemoveAction().updateLogOutTime(token.getValue());
                }
                iterator.remove();
            }
        }
    }
}
