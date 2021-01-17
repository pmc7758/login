package com.pang.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    private static final String SING = "!DAD25K@#DAH14JD%DA45JD13546";//密钥


    //生成token（header.payload.sing）
    public static String getToken(Map<String, String> map) {

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);//默认7天过期

        JWTCreator.Builder builder = JWT.create(); //生成Builder对象
        //生成令牌的payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        //指定过期时间
        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SING));
/*
        String token = JWT.create()
                .withClaim("userid",12)
                .withClaim("username","xiaochen")
                .withExpiresAt(instance.getTime()) //指定令牌过期时间
                .sign(Algorithm.HMAC256(SING));
                等同上面的代码，做了封装

    */
        return token;
    }


    //验证token
    public static DecodedJWT verify(String token) {

        return JWT.require(Algorithm.HMAC256(SING))
                .build()
                .verify(token);
    }

}
