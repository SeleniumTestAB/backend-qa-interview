package com.qa.interview.sollution.full.stack.sollution.frontend.driver;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.qa.interview.sollution.full.stack.sollution.common.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Lazy
@Configuration
@Scope
public class SelenideDriverConfig {

    @Autowired
    private TestConfig testConfig;

    @Bean
    public SelenideDriver selenideDriver() {
        return new SelenideDriver(driverConfig());
    }

    private SelenideConfig driverConfig() {
        SelenideConfig config = new SelenideConfig();
        config.browser(testConfig.getFrontendConfig().getBrowser());
        config.browserSize(testConfig.getFrontendConfig().getBrowserSize());
        config.timeout(testConfig.getFrontendConfig().getTimeout());
        config.headless(testConfig.getFrontendConfig().isHeadless());
        return config;
    }
}
