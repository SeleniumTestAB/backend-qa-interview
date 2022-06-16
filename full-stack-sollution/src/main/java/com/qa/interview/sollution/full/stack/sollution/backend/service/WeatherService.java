package com.qa.interview.sollution.full.stack.sollution.backend.service;

import com.qa.interview.sollution.full.stack.sollution.backend.model.TemperatureMap;
import com.qa.interview.sollution.full.stack.sollution.common.config.TestConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WeatherService {

    @Autowired
    private TestConfig testConfig;


    public Response getWeather() {
        return specification().get();
    }

    public Response modifyTemperature(TemperatureMap payload) {
        return specification().body(payload)
                .put("/temp");
    }

    public Response modifyWeatherCondition(int conditionId) {
        return specification().body(Map.of("condition", conditionId))
                .put("/condition");

    }

    private RequestSpecification specification() {
        return RestAssured.with().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(testConfig.getBackendConfig().getApiUrl())
                .basePath("/weather")
                .log().all()
                .response()
                .log().all()
                .request().filter(new AllureRestAssured());
    }
}
