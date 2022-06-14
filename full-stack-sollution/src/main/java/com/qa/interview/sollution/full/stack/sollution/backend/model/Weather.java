package com.qa.interview.sollution.full.stack.sollution.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Weather(String city,
                      String condition,
                      String icon,
                      int conditionId,
                      String description,
                      @JsonProperty("weather") TemperatureMap temperatures) {
}
