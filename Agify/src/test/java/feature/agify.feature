
Feature: Agify API Tests

  # POSITIVE TEST CASES
  Scenario: Valid name returns age
    When I request age for name "john"
    Then status code is 200
    And response has age field

  Scenario: Another valid name works
    When I request age for name "anna"
    Then status code is 200
    And age is between 1 and 120

  # NEGATIVE TEST CASES
  Scenario: Empty name request
    When I request age for name ""
    Then status code is 200

  Scenario: Special characters in name
    When I request age for name "@#$"
    Then status code is 200
    And response has age field