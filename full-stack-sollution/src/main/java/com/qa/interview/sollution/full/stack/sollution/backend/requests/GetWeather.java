package com.qa.interview.sollution.full.stack.sollution.backend.requests;

import com.qa.interview.sollution.full.stack.sollution.backend.model.Weather;
import com.qa.interview.sollution.full.stack.sollution.backend.service.WeatherService;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.backend.APIRequest;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.common.LazilyWired;

import java.lang.reflect.Type;

@APIRequest
public class GetWeather extends AbstractRequest<GetWeather, Weather> {

    @LazilyWired
    private WeatherService weatherService;

    @Override
    protected Type getModel() {
        return Weather.class;
    }

    @Override
    public GetWeather execute() {
        response = weatherService.getWeather();
        return this;
    }
}
