package com.qa.interview.sollution.full.stack.sollution.frontend.pages.components;

import com.codeborne.selenide.SelenideDriver;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.frontend.PageComponent;
import org.springframework.beans.factory.annotation.Autowired;

@PageComponent
public class CityCurrentForecast {

    @Autowired
    private SelenideDriver selenideDriver;

}
