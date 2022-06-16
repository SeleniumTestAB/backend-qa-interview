@backend @regression
Feature: Weather API Regression tests
  Regression tests for weather API

  Scenario: Weather API should throw error for non-existing condition
    Given the weather forecast is found
    When the weather condition would change to 7
    Then API should throw an error 'bad request'

