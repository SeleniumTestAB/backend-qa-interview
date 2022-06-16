package com.qa.interview.sollution.full.stack.sollution.frontend.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.common.LazilyWired;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.frontend.PageUtil;
import org.openqa.selenium.By;

@PageUtil
public class ElementFinderUtil {

    @LazilyWired
    private SelenideDriver selenideDriver;

    public SelenideElement $x(String xpathExpression) {
        return selenideDriver.$x(xpathExpression);
    }

    public SelenideElement findExisting(By path) {
        return selenideDriver.$(path).should(Condition.exist);
    }

    public SelenideElement findVisible(By path) {
        return findExisting(path).shouldBe(Condition.visible);
    }

    public SelenideElement findEditable(By path) {
        return findExisting(path).shouldBe(Condition.editable);
    }

    public SelenideElement findInnerExisting(SelenideElement parent, By path) {
        return parent.find(path).should(Condition.exist);
    }

    public SelenideElement findInnerVisible(SelenideElement parent, By path) {
        return findInnerExisting(parent, path).should(Condition.visible);
    }

    public SelenideElement findInnerEditable(SelenideElement parent, By path) {
        return findInnerExisting(parent, path).should(Condition.editable);
    }

    public SelenideElement verifyElementExists(SelenideElement element) {
        return element.should(Condition.exist);
    }
}
