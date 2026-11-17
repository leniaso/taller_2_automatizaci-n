@cart
Feature: Remove products from the product list
  As a logged-in shopper
  I want to remove products from my cart on the product list
  So that I only keep what I want to buy

  @smoke
  Scenario: Remove the only product in the cart
    Given the user is logged in as "standard_user"
    And the user has added "Sauce Labs Backpack" to the cart
    When the user removes "Sauce Labs Backpack" from the product list
    Then the cart badge shows 0

  Scenario: Remove one of several products
    Given the user is logged in as "standard_user"
    And the user has added the following products to the cart
      | Sauce Labs Backpack |
      | Sauce Labs Onesie   |
    When the user removes "Sauce Labs Onesie" from the product list
    Then the cart badge shows 1

  Scenario: The button changes back to Add to cart after removing a product
    Given the user is logged in as "standard_user"
    And the user has added "Sauce Labs Backpack" to the cart
    When the user removes "Sauce Labs Backpack" from the product list
    Then the button of "Sauce Labs Backpack" shows "Add to cart"