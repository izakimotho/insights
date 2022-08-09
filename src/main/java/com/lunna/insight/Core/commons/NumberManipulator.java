
package com.lunna.insight.Core.commons;

import java.text.SimpleDateFormat;
import java.util.Date;


public class NumberManipulator {

    public static String getNumberIncByOne(String dbLastNumber, String numberingPrefixPolicy,
                                           String numberingLengthPolicy, String numberingReset) {
        String returnNumber = "";
        String generatedPrefix = generatePreFixByPolicy(numberingPrefixPolicy);
        try {
            boolean isResetRequired = getResetRequired(numberingReset, dbLastNumber, numberingPrefixPolicy);
            if (null == dbLastNumber || isResetRequired) {
                if (null != numberingLengthPolicy) {
                    int length = Integer.parseInt(numberingLengthPolicy);
                    returnNumber = generatedPrefix + appendZero(length, 1);
                }
                return returnNumber;
            } else {
                returnNumber = parseAndIncrementNo(dbLastNumber, generatedPrefix, Integer.parseInt(numberingLengthPolicy), 1);
                return returnNumber;
            }
        } catch (Exception ex) {
            if (null != numberingLengthPolicy) {
                int length = Integer.parseInt(numberingLengthPolicy);
                returnNumber = generatedPrefix + appendZero(length, 1);
            }
            return returnNumber;
        }
    }

    private static boolean getResetRequired(String numberingReset, String dbLastNumber, String numberingPrefixPolicy) {
        boolean isResetRequired = false;
        String[] formatedNumber = parseNumberingPrefix(numberingPrefixPolicy);
        if (null != dbLastNumber
            && (formatedNumber.length > 1 && formatedNumber[1].contains(numberingReset))) {

            String generated = getFormatedDate(new Date(), formatedNumber[1]);
            int endIndex = (formatedNumber[0].length() + formatedNumber[1].length());
            if (generated.length() != formatedNumber[1].length()) {
                endIndex = (formatedNumber[0].length() + generated.length());
            }
            String dbNumber = dbLastNumber.substring(formatedNumber[0].length(), endIndex);


            if (!dbNumber.equalsIgnoreCase(generated)) {
                isResetRequired = true;
            }
        }
        return isResetRequired;
    }

    private static String generatePreFixByPolicy(String numberingPrefixPolicy) {
        if (null != numberingPrefixPolicy) {
            String[] formatedNumber = parseNumberingPrefix(numberingPrefixPolicy);
            if (formatedNumber.length > 1) {
                formatedNumber[0] = formatedNumber[0] + getFormatedDate(new Date(), formatedNumber[1]);
            }
            return formatedNumber[0];
        }
        return "";
    }

    public static String appendZero(int numberingLength, int value) {
        String format = "%0" + ((numberingLength != 0) ? numberingLength : 1) + "d";
        return String.format(format, value);
    }

    public static String[] parseNumberingPrefix(String numberingPrefix) {
        String[] numbers = null;
        if (null != numberingPrefix) {
            numbers = numberingPrefix.split("\\{");
            if (numbers.length > 1) {
                numbers[1] = numbers[1].substring(0, numbers[1].length() - 1);
            }
        }
        return numbers;
    }

	/*public static void main(String[] args) {
        //System.out.println(getNumberIncByOne("CLL101", "CLL{MM}", "0", "M"));
	}*/

    public static String parseAndIncrementNo(String number, String generatedPrefix, int numberingLength, int incrementBy) {
        String returnVal = null;
        int beginIndex = 0;
        if (numberingLength == 0) numberingLength++;
        if (number.length() == (generatedPrefix.length() + numberingLength)) {
            beginIndex = number.length() - numberingLength;
        } else {
            beginIndex = generatedPrefix.length();
        }

        if (generatedPrefix.length() >= number.length()) {
            //number 			= 0213
            //generatedPrefix 	= Pqwerty
            //numberingLength	= 3
            number = generatedPrefix + number;
        }

        returnVal = generatedPrefix;
        String numToBeIncr = number.substring(beginIndex);
        try {
            Integer.parseInt(numToBeIncr);
        } catch (Exception e) {
            numToBeIncr = numToBeIncr.substring(numToBeIncr.indexOf(generatedPrefix) + generatedPrefix.length());
        }
        returnVal += appendZero(numberingLength, Integer.parseInt(numToBeIncr) + incrementBy);
        return returnVal;
    }

    public static String getFormatedDate(Date date, String formate) {
        SimpleDateFormat formatNowYear = new SimpleDateFormat(formate);
        return formatNowYear.format(date);
    }
}
