package com.lunna.insight.Core.security.session;


public class TokenResponse {
    private boolean allowChange;
    private String errorMessage;

    public TokenResponse() {
    }

    public TokenResponse(boolean allowChange, String errorMessage) {
        this.allowChange = allowChange;
        this.errorMessage = errorMessage;
    }

    public TokenResponse(boolean allowChange) {
        this.allowChange = allowChange;
    }

    public boolean isAllowChange() {
        return allowChange;
    }

    public void setAllowChange(boolean allowChange) {
        this.allowChange = allowChange;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
