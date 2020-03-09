package com.sys.appstore.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sys.appstore.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class TokenUtil {

    public static final long EXPIRE_TIME = 30 * 60 * 1000;

    /**
     * 生成Token，30min过期
     *
     * @param username
     * @param secret
     * @return
     */
    public static String sign(String username, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
    }

    /**
     * 刷新token
     * @param token
     * @param redisUtil
     * @return
     * @throws GlobalException
     */
    public static String refresh(String token, RedisUtil redisUtil) throws GlobalException {
        if (redisUtil.expire(token, EXPIRE_TIME / 1000)) {
            return token;
        } else {
            throw new GlobalException(20003, "token设置失败！");
        }
    }

}
