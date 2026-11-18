@cart @regression
Feature: Shopping cart management
  As a SauceDemo shopper
  I want to review and modify my cart
  So that I confirm what I am going to buy before checkout

  Background:
    Given the user is logged in as "standard_user"

  @smoke
  Scenario Outline: View the name, price and quantity of a product in the cart
    Given the user has added "<product>" to the cart
    When the user opens the cart
    Then the cart shows "<product>" priced at "<price>" with quantity "1"

    Examples:
      | product                           | price  |
      | Sauce Labs Backpack               | $29.99 |
      | Sauce Labs Bike Light             | $9.99  |
      | Sauce Labs Bolt T-Shirt           | $15.99 |
      | Sauce Labs Fleece Jacket          | $49.99 |
      | Sauce Labs Onesie                 | $7.99  |
      | Test.allTheThings() T-Shirt (Red) | $15.99 |

  Scenario: View several products in the cart
    Given the user has added the following products to the cart
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    When the user opens the cart
    Then the cart contains the following products
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    And the cart item total is 2
    And the cart badge matches the cart item total

  @smoke
  Scenario: Remove a product from the cart
    Given the user has added the following products to the cart
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    And the user is in the cart
    When the user removes "Sauce Labs Backpack" from the cart
    Then the cart contains the following products
      | Sauce Labs Bike Light |
    And the cart item total is 1

  Scenario: Removing the last product leaves the cart empty
    Given the user has added "Sauce Labs Onesie" to the cart
    And the user is in the cart
    When the user removes "Sauce Labs Onesie" from the cart
    Then the cart is empty
    And the cart badge matches the cart item total

  @boundary
  Scenario: A new cart is empty
    When the user opens the cart
    Then the cart is empty
    And the cart item total is 0

  Scenario: Continue Shopping goes back to the catalog and keeps the cart content
    Given the user has added the following products to the cart
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    And the user is in the cart
    When the user continues shopping
    Then the user is on the "Products" page
    When the user opens the cart
    Then the cart contains the following products
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

  Scenario: The cart persists after reloading the page
    Given the user has added the following products to the cart
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
    And the user is in the cart
    When the user reloads the page
    Then the cart contains the following products
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |

  @boundary
  Scenario: Cart with all six catalog products
    Given the user has added the following products to the cart
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    When the user opens the cart
    Then the cart item total is 6
    And the cart badge matches the cart item total
