@Consumption
@WIP
Feature: Cucumber consumption
  As a business owner,
  I want to know how much cucumbers my consumers eat,
  So i can offer individual plans later on

  Scenario: Eating less cucumbers than I have
    Given I have 12 cucumbers
    When I eat 5 cucumbers
    Then I have 7 cucumbers left

  Scenario: Eating more cucumbers than I have
    Given I have 12 cucumbers
    When I eat 20 cucumbers
    Then I have 12 cucumbers left