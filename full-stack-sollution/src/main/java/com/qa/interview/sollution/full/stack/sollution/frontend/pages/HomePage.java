package com.qa.interview.sollution.full.stack.sollution.frontend.pages;

import com.qa.interview.sollution.full.stack.sollution.common.config.TestConfig;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.common.LazilyWired;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.frontend.Page;

@Page
public class HomePage extends BasePage {
    @LazilyWired
    private TestConfig testConfig;

    public HomePage openApp() {
        selenideDriver.open(testConfig.getFrontendConfig().getHomePageUrl());
        return this;
    }

}
