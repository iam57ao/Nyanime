package com.iam57.nyanime.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.Map;

/**
 * @author iam57
 * @since 2024-03-25 18:59:11
 */
public class JWTUtil {
    public static String createToken(Map<String, Object> claims, String secret, Long ttlMillis) {
        return JWT.create()
                .withPayload(claims)
                .withExpiresAt(new Date().toInstant().plusMillis(ttlMillis))
                .sign(Algorithm.HMAC256(secret));
    }

    public static Map<String, Claim> parseJWT(String token, String secret) {
        return JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token)
                .getClaims();
    }

    public static Map<String, Claim> getClaims() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        String token = requestAttributes.getRequest().getHeader("Authorization");
        return JWT.decode(token).getClaims();
    }
}
