
package com.lunna.insight.Core.commons;


public class DtsStringFunctions {

    public String replaceAll(String strToCheck, String regex, String replacement) {
        if (strToCheck == null) {
            return "''";
        } else {
            return "'" + strToCheck.replaceAll(regex, replacement) + "'";
        }
    }
}
