@checkout @regression
Feature: Checkout step two - order overview and confirmation
  As a SauceDemo shopper
  I want to review my order before paying
  So that I only confirm what I really selected

  Background:
    Given the user is logged in as "standard_user"
    And the user has added the following products to the cart
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    And the user is on the order overview

  @smoke
  Scenario: The summary matches the selected products
    Then the order summary lists the following products
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

  Scenario: The item total is consistent with the product prices
    Then the item total is the sum of the product prices

  Scenario: The order total is the item total plus the tax
    Then the order total is the item total plus the tax

  @smoke
  Scenario: Finishing the purchase shows the confirmation
    When the user finishes the purchase
    Then the user is on the "Checkout: Complete!" page
    And the purchase confirmation "Thank you for your order!" is displayed

  Scenario: Cancelling the purchase returns to the products page
    When the user cancels the purchase
    Then the user is on the "Products" page
    And the cart badge shows 2

  Scenario: Going back home after the purchase leaves an empty cart
    When the user finishes the purchase
    And the user goes back home
    Then the user is on the "Products" page
    And the cart badge shows 0
