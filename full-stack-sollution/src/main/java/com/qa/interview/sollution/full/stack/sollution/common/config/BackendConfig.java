package com.qa.interview.sollution.full.stack.sollution.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "backend")
public class BackendConfig {
    private String apiUrl;
}
