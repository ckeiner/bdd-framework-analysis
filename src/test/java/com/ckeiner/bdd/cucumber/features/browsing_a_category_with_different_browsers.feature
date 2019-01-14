@Web
Feature: Browsing a Category with Background

  Scenario Outline: Browse a top level category
    Given <browser> is opened
    And I open the homepage
    When I open the category <category>
    Then I see the catalogue

    @Chrome
    Examples: 
      | browser | category        |
      | Chrome  | World of Nature |

    @Firefox
    Examples: 
      | browser | category |
      | Firefox | Flowers  |
