package com.qa.interview.sollution.full.stack.sollution.frontend.pages;

import com.codeborne.selenide.SelenideDriver;
import com.qa.interview.sollution.full.stack.sollution.frontend.pages.components.ApplicationBanner;
import com.qa.interview.sollution.full.stack.sollution.frontend.pages.components.SearchBar;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
public abstract class BasePage {

    @Autowired
    protected SelenideDriver selenideDriver;

    @Autowired
    protected SearchBar searchBar;

    @Autowired
    protected ApplicationBanner banner;
}
