@AddToCart
@WIP
Feature: Add To Cart
  As a client,
  I want to be able to add products to the cart,
  So i can buy them all at once

  Scenario: Place a random product in the cart
    Given Chrome is opened
    And I open the homepage
    When I search for a random product
    And I place the product in the cart
    Then the product should be in the cart