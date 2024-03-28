package com.iam57.nyanime.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author iam57
 * @since 2024-03-25 15:43:28
 */
@Data
@Component
@ConfigurationProperties(prefix = "nyanime.jwt")
public class JWTProperties {
    private String header;
    private String secret;
    private Long expireTime;
}
