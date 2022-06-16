package com.qa.interview.sollution.full.stack.sollution.steps.frontend;

import com.neovisionaries.i18n.CountryCode;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.common.LazilyWired;
import com.qa.interview.sollution.full.stack.sollution.frontend.dictonary.CityDict;
import com.qa.interview.sollution.full.stack.sollution.frontend.pages.CityWeatherPage;
import com.qa.interview.sollution.full.stack.sollution.frontend.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@CucumberContextConfiguration
public class WeatherSiteSteps {

    @LazilyWired
    private HomePage homePage;

    private CityWeatherPage foundCityPage;

    private String mainTitle, subText, expectedCityName;

    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        homePage.openApp();
    }

    @When("Text from banner was acquired")
    public void textFromBannerWasAcquired() {
        mainTitle = homePage.getBanner().getBannersMainText();
        subText = homePage.getBanner().getBannersSubText();
    }

    @Then("The main title should be {string}")
    public void verifyMainTitle(String expectedMainTitle) {
        assertThat(mainTitle).isEqualTo(expectedMainTitle);

    }

    @And("The sub text should be {string}")
    public void verifySubText(String expectedSubText) {
        assertThat(subText).isEqualTo(expectedSubText);
    }

    @When("User finds current forecast for city {string} from {string}")
    public void userFindsCurrentForecastForSpecificCity(String city, String country) {
        String foundCode = Arrays.stream(CountryCode.values()).filter(countryCode -> countryCode.getName().equalsIgnoreCase(country))
                .findFirst()
                .get().name();
        expectedCityName = String.format("%s, %s", city, foundCode);
        foundCityPage = homePage.getSearchBar().searchFor(expectedCityName);
        foundCityPage.verifyUserIsOnRightCityPage(CityDict.SYDNEY_AU.getCityId());
    }

    @Then("Forecast should have proper city name and time")
    public void forecastShouldHaveProperCityNameAndTime() {
        foundCityPage.getCurrentForecast().verifyCityNameField(expectedCityName);
        foundCityPage.getCurrentForecast().verifyCurrentTimeDisplayed(CityDict.SYDNEY_AU.getZoneId(), CityDict.SYDNEY_AU.getCountry());
    }

}
