package com.iam57.nyanime.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.iam57.nyanime.properties.JWTProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author iam57
 * @since 2024-03-25 18:59:11
 */
@Component
@AllArgsConstructor
public class JWTUtil {
    private JWTProperties jwtProperties;

    private String getTokenByTokenHeader(String tokenHeader) {
        return tokenHeader.replace("Bearer ", "");
    }

    public String createToken(Map<String, Object> claims) {
        return JWT.create()
                .withPayload(claims)
                .withExpiresAt(new Date().toInstant().plusMillis(jwtProperties.getExpireTime()))
                .sign(Algorithm.HMAC256(jwtProperties.getSecret()));
    }

    public boolean parseJWT(String tokenHeader) {
        String token = this.getTokenByTokenHeader(tokenHeader);
        try {
            JWT.decode(token);
        } catch (JWTDecodeException jwtDecodeException) {
            return false;
        }
        return true;
    }

    public Map<String, Claim> getClaims() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String tokenHeader = Objects.requireNonNull(requestAttributes).getRequest().getHeader(jwtProperties.getHeader());
        String token = getTokenByTokenHeader(tokenHeader);
        return JWT.decode(token).getClaims();
    }
}
