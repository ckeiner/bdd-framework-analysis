@Web
Feature: Browsing a Category without Background

  Scenario: Browse a top level category
    Given Chrome is opened
    And I open the homepage
    When I open the category World of Nature
    Then I see the catalogue

  Scenario: Browse a sub level category
    Given Chrome is opened
    And I open the homepage
    When I open the subcategory Flowers of the category World of Nature
    Then I see the catalogue