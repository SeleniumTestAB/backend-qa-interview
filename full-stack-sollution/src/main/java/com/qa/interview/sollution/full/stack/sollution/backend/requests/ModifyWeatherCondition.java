package com.qa.interview.sollution.full.stack.sollution.backend.requests;

import com.qa.interview.sollution.full.stack.sollution.backend.service.WeatherService;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.backend.APIRequest;
import com.qa.interview.sollution.full.stack.sollution.custom.annotations.common.LazilyWired;
import lombok.Setter;

import java.lang.reflect.Type;
@APIRequest
public class ModifyWeatherCondition extends AbstractRequest<ModifyWeatherCondition, String>{

    @Setter
    private int conditionId;

    @LazilyWired
    private WeatherService weatherService;
    @Override
    protected Type getModel() {
        return String.class;
    }

    @Override
    public ModifyWeatherCondition execute() {
        response = weatherService.modifyWeatherCondition(this.conditionId);
        return this;
    }
}
