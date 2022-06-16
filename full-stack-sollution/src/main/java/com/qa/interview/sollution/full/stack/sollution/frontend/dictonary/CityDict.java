package com.qa.interview.sollution.full.stack.sollution.frontend.dictonary;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CityDict {

    SYDNEY_AU("Australia", "AET", "2147714");

    private final String country;
    private final String zoneId;
    private final String cityId;

}
