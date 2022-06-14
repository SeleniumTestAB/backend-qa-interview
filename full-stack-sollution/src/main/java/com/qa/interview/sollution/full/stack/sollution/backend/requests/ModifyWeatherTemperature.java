package com.qa.interview.sollution.full.stack.sollution.backend.requests;

import com.qa.interview.sollution.full.stack.sollution.backend.model.TemperatureMap;
import com.qa.interview.sollution.full.stack.sollution.backend.service.WeatherService;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.common.LazilyWired;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.lang.reflect.Type;

public class ModifyWeatherTemperature extends AbstractRequest<ModifyWeatherTemperature, String> {

    @Setter
    @Accessors(fluent = true)
    private TemperatureMap payload;

    @LazilyWired
    private WeatherService weatherService;

    @Override
    protected Type getModel() {
        return String.class;
    }

    @Override
    public ModifyWeatherTemperature execute() {
        response = weatherService.modifyTemperature(payload);
        return this;
    }
}
