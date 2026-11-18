@checkout @regression
Feature: Checkout step one - shipping information
  As a SauceDemo shopper
  I want to enter my shipping data
  So that I can continue with the purchase of the products in my cart

  Background:
    Given the user is logged in as "standard_user"
    And the user has added "Sauce Labs Backpack" to the cart
    And the user is on the shipping information form

  @smoke
  Scenario: Valid shipping data leads to the order overview
    When the user fills the shipping information with "valid data"
    Then the user is on the "Checkout: Overview" page

  Scenario Outline: Required fields of the shipping form are validated
    When the user fills the shipping information with "<case>"
    Then the checkout error message "<message>" is displayed
    And the user is on the "Checkout: Your Information" page

    Examples:
      | case                | message                        |
      | missing first name  | Error: First Name is required  |
      | missing last name   | Error: Last Name is required   |
      | missing postal code | Error: Postal Code is required |
      | no data             | Error: First Name is required  |

  Scenario: Cancelling the shipping form goes back to the cart
    When the user cancels the shipping information form
    Then the user is on the "Your Cart" page
    And the cart contains the following products
      | Sauce Labs Backpack |
