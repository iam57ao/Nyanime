package com.iam57.nyanime.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
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
    private static String getTokenByTokenHeader(String tokenHeader) {
        return tokenHeader.replace("Bearer ", "");
    }

    public static String createToken(Map<String, Object> claims, String secret, Long ttlMillis) {
        return JWT.create()
                .withPayload(claims)
                .withExpiresAt(new Date().toInstant().plusMillis(ttlMillis))
                .sign(Algorithm.HMAC256(secret));
    }

    public static boolean parseJWT(String tokenHeader) {
        String token = getTokenByTokenHeader(tokenHeader);
        try {
            JWT.decode(token);
        } catch (JWTDecodeException jwtDecodeException) {
            return false;
        }
        return true;

    }

    public static Map<String, Claim> getClaims() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        String tokenHeader = requestAttributes.getRequest().getHeader("Authorization");
        String token = getTokenByTokenHeader(tokenHeader);
        return JWT.decode(token).getClaims();
    }
}
