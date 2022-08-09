
package com.lunna.insight.Core.security;


import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AES {

    private final static String ALGORITHM = "AES";

    public static String encrypt(String input) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, generateKey());
            return encodeString(cipher.doFinal(input.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decrypt(String input) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, generateKey());
            String value = new String(cipher.doFinal(decodeString(input)));
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // generates a secret key
    private static Key generateKey() throws Exception {
        try {
            byte[] keyval = "@compulynx#54321".getBytes();
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            keyval = digest.digest(keyval);
            keyval = Arrays.copyOf(keyval, 16);
            Key key = new SecretKeySpec(keyval, ALGORITHM);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String encodeString(byte[] input) {
        return Base64.encodeBase64URLSafeString(input);
    }

    private static byte[] decodeString(String output) {
        return Base64.decodeBase64(output);
    }

    public static String getHashKey(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        //convert the byte to hex format method 2
        StringBuilder hexString = new StringBuilder();
        for (byte aByteData : byteData) {
            String hex = Integer.toHexString(0xff & aByteData);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static boolean validateHashKey(String hashKey, int tenantId, String domainName) throws Exception {
        String passWord = domainName + "NexxRetailApplicationLicense" + tenantId;
        passWord = AES.encrypt(passWord);
        return getHashKey(passWord).equals(hashKey);
    }
}
