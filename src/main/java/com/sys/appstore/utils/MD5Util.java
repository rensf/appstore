package com.sys.appstore.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {

    private static final String SECRET_KEY = "123";

    public static String makeMD5(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] btInput = str.getBytes("UTF-8");
        md.update(btInput);
        String strMD5 = new BigInteger(1, md.digest()).toString(16);
        return strMD5;
    }

    public static String makePwd(String name, String password) throws Exception {
        return MD5Util.makeMD5(name.toUpperCase() + password + MD5Util.SECRET_KEY);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(makePwd("admin","123456"));
    }
}
