@Consumption
Feature: Cucumber Consumption with Data

  Scenario Outline: Eating cucumbers
    Given I have <have> cucumbers
    When I eat <eat> cucumbers
    Then I have <left> cucumbers left
    
    Examples:
      | have | eat | left|
      |  12  |  5  |  7  |
      |  0   |  0  |  0  |