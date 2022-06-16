@backend @smoke
Feature: Weather API Smoke tests
  Smoke tests for weather API

  Scenario Outline: Weather should change based on temperature
    Given the temperature in '<tempType>' would be <tempValue>
    When the weather forecast is found
    Then the description should be 'The weather is <weatherState>'

    Examples:
      | tempType   | tempValue | weatherState |
      | fahrenheit | 32        | freezing     |
      | fahrenheit | 41        | cold         |
      | fahrenheit | 49        | cold         |
      | fahrenheit | 34        | cold         |
      | fahrenheit | 50        | mild         |
      | fahrenheit | 59        | mild         |
      | fahrenheit | 67        | mild         |
      | fahrenheit | 68        | warm         |
      | fahrenheit | 72        | warm         |
      | fahrenheit | 75        | warm         |
      | fahrenheit | 77        | hot          |
      | fahrenheit | 86        | hot          |
      | fahrenheit | 212       | hot          |


  Scenario Outline: Weather should change based on condition
    Given the weather condition would change to <conditionId>
    When the weather forecast is found
    Then the condition with '<conditionName>' is as expected

    Examples:
      | conditionId | conditionName |
      | 1           | clear         |
      | 2           | windy         |
      | 3           | mist          |
      | 4           | drizzle       |
      | 5           | dust          |