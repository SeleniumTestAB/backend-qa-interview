@UI
Feature: Frontend for OpenWeather
  Tests related to UI

  Scenario: Proper banner text displays on Home Page
    Given User is on Home Page
    When Text from banner was acquired
    Then The main title should be 'OpenWeather'
    And The sub text should be 'Weather forecasts, nowcasts and history in fast and elegant way'

  Scenario: Proper information is displayed on current forecast for Sydney, AU
    Given User is on Home Page
    When User finds current forecast for city 'Sydney' from 'Australia'
    Then Forecast should have proper city name and time