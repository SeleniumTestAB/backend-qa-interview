package com.qa.interview.sollution.full.stack.sollution;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.qa.interview.sollution.full.stack.sollution.steps",
        plugin = {
        "pretty",
        "html:target/cucumber-reports"
        }
        )
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
