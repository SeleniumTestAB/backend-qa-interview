package com.qa.interview.sollution.full.stack.sollution.steps;

import com.qa.interview.sollution.full.stack.sollution.common.config.TestConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest
//@CucumberContextConfiguration
public class SpringSteps {

    @Autowired
    private TestConfig testConfig;

    @Test
    public void testConfigYaml() {
        System.out.println(testConfig.getBackendConfig().getApiUrl());
        System.out.println(testConfig.getFrontendConfig().getBrowser());
    }

}
