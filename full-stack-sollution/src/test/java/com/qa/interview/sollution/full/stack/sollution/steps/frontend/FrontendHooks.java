package com.qa.interview.sollution.full.stack.sollution.steps.frontend;

import com.codeborne.selenide.SelenideDriver;
import io.cucumber.java.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


public class FrontendHooks {

    @Autowired
    private ApplicationContext ctx;

    @After("@UI")
    public void quitDriver() {
        ctx.getBean(SelenideDriver.class).close();
    }
}
