/*
 * Copyright (c) 2016 FC-ServiceStack Compulynx LTD.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are NOT permitted.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL COMPULYNX LTD BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.lunna.insight.Core.security.session;

import java.util.HashMap;
import java.util.Map;


public class TokenStore {
    private Map<String, Token> tokens = new HashMap<>();

    private TokenStore() {
    }

    public static TokenStore getInstance() {
        return TokenStoreHolder.INSTANCE;
    }

    public void push(String value, Token token) {
        tokens.put(value, token);
    }

    public Token get(String key) {
        Token token = null;
        if (tokens.containsKey(key)) {
            token = tokens.get(key);
        }
        return token;
    }

    protected Map<String, Token> getTokens() {
        return tokens;
    }

    private static class TokenStoreHolder {
        private static final TokenStore INSTANCE = new TokenStore();
    }
}
