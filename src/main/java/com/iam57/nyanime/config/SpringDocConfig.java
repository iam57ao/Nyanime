package com.iam57.nyanime.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author iam57
 * @since 2024-03-18 20:20:32
 */
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Nyanime API")
                        .description("Nyanime API接口文档")
                        .version("v0.0.1"));
    }
}
