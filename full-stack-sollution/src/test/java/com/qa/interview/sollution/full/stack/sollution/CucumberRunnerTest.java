package com.qa.interview.sollution.full.stack.sollution;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.BeforeAll;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.qa.interview.sollution.full.stack.sollution.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

    @BeforeAll()
    public void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(false));
    }
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
