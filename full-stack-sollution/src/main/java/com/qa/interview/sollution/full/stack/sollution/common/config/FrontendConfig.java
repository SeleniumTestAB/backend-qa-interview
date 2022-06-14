package com.qa.interview.sollution.full.stack.sollution.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "frontend")
public class FrontendConfig {
    private String homePageUrl;
    private boolean headless;
    private long timeout;
    private String browserSize;
    private String browser;
}

