package com.qa.interview.sollution.full.stack.sollution.frontend.pages;

import com.codeborne.selenide.SelenideDriver;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.common.LazilyWired;
import com.qa.interview.sollution.full.stack.sollution.frontend.pages.components.ApplicationBanner;
import com.qa.interview.sollution.full.stack.sollution.frontend.pages.components.SearchBar;
import lombok.Getter;

@Getter
public abstract class BasePage {

    @LazilyWired
    protected SelenideDriver selenideDriver;

    @LazilyWired
    protected SearchBar searchBar;

    @LazilyWired
    protected ApplicationBanner banner;


}
