package com.qa.interview.sollution.full.stack.sollution.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//TODO remove once tested that record works as intended
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureUpdatePayload {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String tempInFahrenheit;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String tempInCelsius;
}
