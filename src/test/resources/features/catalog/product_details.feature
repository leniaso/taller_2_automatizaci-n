@catalog
Feature: View product details
  As a logged-in shopper
  I want to open a product's details page
  So that I can see its information before buying

  @smoke
  Scenario: View the details of a product
    Given the user is logged in as "standard_user"
    When the user opens the details of "Sauce Labs Bike Light"
    Then the product details show "Sauce Labs Bike Light" priced at "$9.99"

  Scenario: Add a product to the cart from its details page
    Given the user is logged in as "standard_user"
    And the user is viewing the details of "Sauce Labs Backpack"
    When the user adds the product to the cart from its details page
    Then the cart badge shows 1

  Scenario: Go back to the product list from the details page
    Given the user is logged in as "standard_user"
    And the user is viewing the details of "Sauce Labs Backpack"
    When the user goes back to the products
    Then the product list shows 6 products