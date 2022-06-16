package com.qa.interview.sollution.full.stack.sollution.steps.backend;

import com.qa.interview.sollution.full.stack.sollution.backend.dictonary.ErrorDict;
import com.qa.interview.sollution.full.stack.sollution.backend.model.ErrorModel;
import com.qa.interview.sollution.full.stack.sollution.backend.model.TemperatureMap;
import com.qa.interview.sollution.full.stack.sollution.backend.model.Weather;
import com.qa.interview.sollution.full.stack.sollution.backend.requests.GetWeather;
import com.qa.interview.sollution.full.stack.sollution.backend.requests.ModifyWeatherCondition;
import com.qa.interview.sollution.full.stack.sollution.backend.requests.ModifyWeatherTemperature;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherApiSteps {

    @Autowired
    private GetWeather getWeatherRequest;

    @Autowired
    private ModifyWeatherTemperature modifyWeatherTemperatureRequest;

    @Autowired
    private ModifyWeatherCondition modifyWeatherConditionRequest;

    private int expectedConditionId;
    private Weather actualWeather;

    @Given("the temperature in {string} would be {}")
    public void theTemperatureInTempTypeWouldBeTempValue(String tempType, BigDecimal tempValue) {
        TemperatureMap modification = TemperatureMap.builder()
                .tempInCelsius(tempType.equalsIgnoreCase("celsius") ? tempValue.intValueExact() : 0)
                .tempInFahrenheit(tempType.equalsIgnoreCase("fahrenheit") ? tempValue.intValueExact() : 0)
                .build();
        modifyWeatherTemperatureRequest.setPayload(modification);
        modifyWeatherTemperatureRequest.execute();
    }

    @When("the weather forecast is found")
    public void theWeatherForecastIsFound() {
        actualWeather = getWeatherRequest.execute().getResponseAsObject();
    }

    @Then("the description should be {string}")
    public void theDescriptionShouldBeTheWeatherIsWeatherState(String weatherState) {
        assertThat(actualWeather.description()).isEqualTo(weatherState);
    }

    @Given("the weather condition would change to {}")
    public void theWeatherConditionWouldBeConditionId(int conditionId) {
        this.expectedConditionId = conditionId;
        modifyWeatherConditionRequest.setConditionId(conditionId);
        modifyWeatherConditionRequest.execute();
    }

    @Then("the condition with {string} is as expected")
    public void theConditionChangedAsExpected(String conditionName) {
        assertThat(actualWeather.condition()).isEqualTo(conditionName);
        assertThat(actualWeather.icon()).isEqualTo(conditionName + ".png");
    }

    @Then("API should throw an error {}")
    public void apiShouldThrowAnError(String error) {
        if (error.equalsIgnoreCase("bad request")) {
            ErrorModel errorBody = modifyWeatherConditionRequest.getError();
            assertThat(errorBody.error()).isEqualTo(ErrorDict.BAD_REQUEST_CONDITION.getError());
            assertThat(errorBody.status()).isEqualTo(ErrorDict.BAD_REQUEST_CONDITION.getStatus());
            assertThat(errorBody.path()).isEqualTo(ErrorDict.BAD_REQUEST_CONDITION.getPath());
        }
    }
}
