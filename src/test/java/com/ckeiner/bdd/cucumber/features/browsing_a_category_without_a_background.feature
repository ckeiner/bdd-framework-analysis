@Web
Feature: Browsing a Category with Background

  Background: Open the Website
    Given Chrome is opened
    And I open the homepage

  Scenario: Browse a top level category
    When I open the category World of Nature
    Then I see the catalogue

  Scenario: Browse a sub level category
    When I open the subcategory Flowers of the category World of Nature
    Then I see the catalogue