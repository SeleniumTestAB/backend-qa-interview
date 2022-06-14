package com.qa.interview.sollution.full.stack.sollution.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Data
public class TestConfig {

    @Autowired
    private FrontendConfig frontendConfig;
    @Autowired
    private BackendConfig backendConfig;
}
