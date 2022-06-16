package com.qa.interview.sollution.full.stack.sollution.frontend.pages.components;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.qa.interview.sollution.full.stack.sollution.frontend.pages.CityWeatherPage;
import com.qa.interview.sollution.full.stack.sollution.frontend.utils.ElementFinderUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SearchDropdown {

    @Autowired
    private ElementFinderUtil elementFinderUtil;

    @Autowired
    private ApplicationContext ctx;

    private SelenideElement root;

    @PostConstruct
    public void initComponent() {
        root = elementFinderUtil.$x("//ul[@class='search-dropdown-menu']");
    }

    public CityWeatherPage chooseOptionByText(String text) {
        findOptionByText(text).click();
        return ctx.getBean(CityWeatherPage.class);
    }

    private SelenideElement findOptionByText(String text) {
        return elementFinderUtil.findInnerEditable(elementFinderUtil.verifyElementExists(root),
                Selectors.byXpath(String.format("./child::li/child::span[text()='%s ']",
                        text)));
    }
}
