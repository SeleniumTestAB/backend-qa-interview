package com.qa.interview.sollution.full.stack.sollution.steps.frontend;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


public class FrontendHooks {

    @Autowired
    private ApplicationContext ctx;

    @Before("@UI")
    public void addLogsToReport() {
        if(!SelenideLogger.hasListener("AllureSelenide")) {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide().includeSelenideSteps(true)
                    .screenshots(true)
                    .savePageSource(false));
        }
    }

    @After("@UI")
    public void quitDriver() {
        ctx.getBean(SelenideDriver.class).close();
    }
}
