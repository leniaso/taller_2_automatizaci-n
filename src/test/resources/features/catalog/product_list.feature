@catalog
Feature: Browse the product catalog
  As a logged-in shopper
  I want to see and sort the products
  So that I can find what I want to buy

  @smoke
  Scenario: The catalog lists six products
    Given the user is on the login page
    When the user logs in as "standard_user" with password "secret_sauce"
    Then the product list shows 6 products

  Scenario Outline: Sort the products
    Given the user is logged in as "standard_user"
    When the user sorts the products by "<option>"
    Then the products are listed according to "<option>"

    Examples:
      | option              |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |

  Scenario: Each product has its own image
    Given the user is on the login page
    When the user logs in as "standard_user" with password "secret_sauce"
    Then the product list shows 6 different images

  Scenario Outline: Each product is listed with its price
    Given the user is on the login page
    When the user logs in as "standard_user" with password "secret_sauce"
    Then the product "<product>" is listed with price "<price>"

    Examples:
      | product                           | price  |
      | Sauce Labs Backpack               | $29.99 |
      | Sauce Labs Bike Light             | $9.99  |
      | Sauce Labs Bolt T-Shirt           | $15.99 |
      | Sauce Labs Fleece Jacket          | $49.99 |
      | Sauce Labs Onesie                 | $7.99  |
      | Test.allTheThings() T-Shirt (Red) | $15.99 |