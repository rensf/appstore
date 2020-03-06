package com.sys.appstore.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenUtil {

    public static final long EXPIRE_TIME = 30*60*1000;

    /**
     * 生成Token，5min过期
     * @param username
     * @param secret
     * @return
     */
    public static String sign(String username, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
    }

    public static String refresh() {
        return "";
    }




}
