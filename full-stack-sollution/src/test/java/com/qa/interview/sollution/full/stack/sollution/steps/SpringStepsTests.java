package com.qa.interview.sollution.full.stack.sollution.steps;

import com.qa.interview.sollution.full.stack.sollution.common.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
//@CucumberContextConfiguration
public class SpringStepsTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestConfig testConfig;

    @Test
    public void testConfigYaml() {
        System.out.println(testConfig.getBackendConfig().getApiUrl());
        System.out.println(testConfig.getFrontendConfig().getBrowser());
    }

}
