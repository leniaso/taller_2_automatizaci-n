@cart
Feature: Add products to the cart
  As a logged-in shopper
  I want to add products to my cart
  So that I can buy them later

  @smoke
  Scenario: Add one product to the cart
    Given the user is logged in as "standard_user"
    When the user adds "Sauce Labs Backpack" to the cart
    Then the cart badge shows 1

  Scenario: Add several products to the cart
    Given the user is logged in as "standard_user"
    When the user adds the following products to the cart
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
      | Sauce Labs Onesie     |
    Then the cart badge shows 3