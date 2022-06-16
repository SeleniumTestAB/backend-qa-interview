package com.qa.interview.sollution.full.stack.sollution.frontend.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.common.LazilyWired;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.frontend.PageComponent;
import com.qa.interview.sollution.full.stack.sollution.frontend.utils.ElementFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@PageComponent
public class ApplicationBanner {

    @LazilyWired
    private ElementFinderUtil elementFinderUtil;

    private SelenideElement root;

    @PostConstruct
    public void initComponent() {
        root = elementFinderUtil.$x("//div[@class='section where-to']");
    }


    public String getBannersMainText() {
        return findBannersMainTextField().text();
    }

    public String getBannersSubText() {
        return findBannersSubTextField().text();
    }

    private SelenideElement findBannersSubTextField() {
        return elementFinderUtil.findInnerVisible(elementFinderUtil.verifyElementExists(root), Selectors.byXpath("./descendant::h4/b"));
    }

    private SelenideElement findBannersMainTextField() {
        return elementFinderUtil.findInnerVisible(elementFinderUtil.verifyElementExists(root), Selectors.byXpath("./descendant::span"));
    }
}
