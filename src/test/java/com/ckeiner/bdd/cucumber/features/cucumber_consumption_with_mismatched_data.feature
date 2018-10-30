@Consumption
@Mismatched
Feature: Cucumber Consumption with mismatched data
  I want to add stuff

  Scenario Outline: Cucumber Outline Subtraction
    Given I have <have> cucumbers
    When I eat <eat> cucumbers
    Then I have <left> cucumbers left
    
    Examples: 
      | have  | eat  | left |
      |   7   |  5   |   2  |
      |  7.5  | 2.5  |   5  |
      |  7.1  | 2.9  |  4.2 |
      |  ten  |seven |three |
