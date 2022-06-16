package com.qa.interview.sollution.full.stack.sollution.frontend.pages;

import com.qa.interview.sollution.full.stack.sollution.custom.annotations.frontend.Page;
import com.qa.interview.sollution.full.stack.sollution.frontend.pages.components.CityCurrentForecast;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@Page
public class CityWeatherPage extends BasePage {

    @Autowired
    @Getter
    private CityCurrentForecast currentForecast;

    @SneakyThrows
    public CityWeatherPage verifyUserIsOnRightCityPage(String cityId) {
        selenideDriver.Wait().until(ExpectedConditions.urlContains(String.format("/city/%s", cityId)));
        assertThat(this.selenideDriver.url()).contains(String.format("/city/%s", cityId));
        return this;
    }


}
