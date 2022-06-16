package com.qa.interview.sollution.full.stack.sollution.frontend.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.frontend.PageComponent;
import com.qa.interview.sollution.full.stack.sollution.frontend.pages.CityWeatherPage;
import com.qa.interview.sollution.full.stack.sollution.frontend.utils.ElementFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@PageComponent
public class SearchBar {

    @Autowired
    private ElementFinderUtil elementFinderUtil;

    @Autowired
    private SearchDropdown searchDropdown;

    private SelenideElement root;

    @PostConstruct
    public void initComponent() {
        root = elementFinderUtil.$x("//div[@class='search-container']");
    }

    public CityWeatherPage searchFor(String searchCriteria) {
        this.inputSearchCriteria(searchCriteria)
                .clickOnSearchButton();
        return this.searchDropdown.chooseOptionByText(searchCriteria);
    }

    public SearchBar inputSearchCriteria(String searchCriteria) {
        findSearchBarInput().setValue(searchCriteria)
                .shouldNotBe(Condition.empty)
                .shouldHave(Condition.value(searchCriteria));
        return this;
    }

    public SearchBar clickOnSearchButton() {
        findSearchButton().click();
        return this;
    }


    private SelenideElement findSearchButton() {
        return elementFinderUtil.findInnerEditable(elementFinderUtil.verifyElementExists(root), Selectors.byXpath("./following-sibling::button[@type='submit']"));
    }
    private SelenideElement findSearchBarInput() {
        return elementFinderUtil.findInnerEditable(elementFinderUtil.verifyElementExists(root), Selectors.byXpath("./input"));
    }
}
