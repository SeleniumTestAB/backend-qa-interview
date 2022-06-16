package com.qa.interview.sollution.full.stack.sollution.frontend.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.neovisionaries.i18n.LocaleCode;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.common.LazilyWired;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.frontend.PageComponent;
import com.qa.interview.sollution.full.stack.sollution.frontend.utils.ElementFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;

@PageComponent
public class CityCurrentForecast {

    @LazilyWired
    private ElementFinderUtil elementFinderUtil;

    private SelenideElement root;

    @PostConstruct
    public void initComponent() {
        root = elementFinderUtil.$x("//div[@class='current-container mobile-padding']");
    }

    public void verifyCityNameField(String expectedValue) {
        findCityNameField().shouldHave(Condition.text(expectedValue));
    }

    public void verifyCurrentTimeDisplayed(String timeZoneId, String country) {
        ZoneId zoneId = TimeZone.getTimeZone((timeZoneId)).toZoneId();
        Locale foundLocale = Arrays.stream(Locale.getAvailableLocales())
                .filter(locale -> locale.getDisplayCountry().equalsIgnoreCase(country))
                .findFirst()
                .get();
        findCurrentTimeField().shouldHave(Condition.text(ZonedDateTime.now(zoneId)
                .format(DateTimeFormatter.ofPattern("LLL dd, hh:mma").localizedBy(foundLocale))));
    }

    private SelenideElement findCurrentTimeField() {
        return elementFinderUtil.findInnerVisible(elementFinderUtil.verifyElementExists(root),
                Selectors.byXpath("./descendant::span[@class='orange-text']"));
    }

    private SelenideElement findCityNameField() {
        return elementFinderUtil.findInnerVisible(elementFinderUtil.verifyElementExists(root),
                Selectors.byXpath("./descendant::h2"));
    }

}
