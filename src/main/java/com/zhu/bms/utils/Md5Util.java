package com.zhu.bms.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/5/28
 *   Time: 11:13
 */

public class Md5Util {
    public static String getMd5Str(String str) {
        byte[] digest = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            digest = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String Md5Str = new BigInteger(1, digest).toString(16);
        return Md5Str;
    }
}
