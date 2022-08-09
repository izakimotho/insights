/*
 * Copyright (c) 2015 FC-ServiceStack Compulynx LTD.
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lunna.insight.Models.DTO.Common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RestPayload implements Serializable {

    private static final long serialVersionUID = -4329617004242031635L;
    private int maxItems = 12;
    private int page = 1;
    private int inlineCount = 0;
    private int pendingAuthorizations = 0;
    private List results = new ArrayList();
    private String name = "";
    private int localeId = 0;
    private boolean last = false;


    public RestPayload() {
    }

    public RestPayload(int page, int maxItems) {
        this.maxItems = maxItems;
        this.page = page;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getInlineCount() {
        return inlineCount;
    }

    public void setInlineCount(int inlineCount) {
        this.inlineCount = inlineCount;
    }

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocaleId() {
        return localeId;
    }

    public void setLocaleId(int localeId) {
        this.localeId = localeId;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getPendingAuthorizations() {
        return pendingAuthorizations;
    }

    public void setPendingAuthorizations(int pendingAuthorizations) {
        this.pendingAuthorizations = pendingAuthorizations;
    }

}
