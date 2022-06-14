package com.qa.interview.sollution.full.stack.sollution.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record TemperatureMap(@JsonInclude(JsonInclude.Include.NON_DEFAULT) String tempInFahrenheit,
                             @JsonInclude(JsonInclude.Include.NON_DEFAULT) String tempInCelsius) {
}
