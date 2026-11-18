@e2e @regression
Feature: Complete purchase end to end
  As a SauceDemo shopper
  I want to log in, choose products, pay and log out
  So that I can buy from the store from start to finish

  @smoke
  Scenario: Full purchase flow with a product removed along the way
    Given the user is logged in as "standard_user"
    When the user adds the following products to the cart
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    Then the cart badge shows 3
    When the user removes "Sauce Labs Bike Light" from the product list
    Then the cart badge shows 2
    When the user opens the cart
    Then the cart contains the following products
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
    When the user completes the checkout with valid shipping data
    Then the order summary lists the following products
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
    And the item total is the sum of the product prices
    And the order total is the item total plus the tax
    When the user finishes the purchase
    Then the purchase confirmation "Thank you for your order!" is displayed
    When the user goes back home
    Then the cart badge shows 0
    When the user logs out
    Then the login page is displayed
