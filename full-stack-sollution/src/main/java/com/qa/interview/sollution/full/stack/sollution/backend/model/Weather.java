package com.qa.interview.sollution.full.stack.sollution.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Weather(String city,
                      String condition,
                      String icon,
                      String description,
                      @JsonProperty("weather") TemperatureMap temperatures) {
}
