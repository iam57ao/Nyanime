package com.iam57.nyanime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.iam57.nyanime.properties")
public class NyanimeApplication {
    public static void main(String[] args) {
        SpringApplication.run(NyanimeApplication.class, args);
    }
}
