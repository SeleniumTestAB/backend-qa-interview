package com.qa.interview.sollution.full.stack.sollution.backend.requests;

import com.qa.interview.sollution.full.stack.sollution.backend.service.WeatherService;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.common.LazilyWired;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.lang.reflect.Type;

public class ModifyWeatherCondition extends AbstractRequest<ModifyWeatherCondition, String>{

    @Setter
    @Accessors(fluent = true)
    private int conditionId;

    @LazilyWired
    private WeatherService weatherService;
    @Override
    protected Type getModel() {
        return String.class;
    }

    @Override
    public ModifyWeatherCondition execute() {
        response = weatherService.modifyWeatherCondition(conditionId);
        return this;
    }
}
