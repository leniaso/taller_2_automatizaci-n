@catalog @problem_user
Feature: Catalog behavior for the problem user
  As a shopper using the problem user account
  I want the catalog to work as it does for any other user
  So that I can browse and buy products without surprises

  @known_defect @DEF-01
  Scenario: Each product has its own image
    Given the user is on the login page
    When the user logs in as "problem_user" with password "secret_sauce"
    Then the product list shows 6 different images

  @known_defect @DEF-02
  Scenario Outline: Sorting reorders the products
    Given the user is logged in as "problem_user"
    When the user sorts the products by "<option>"
    Then the products are listed according to "<option>"

    Examples:
      | option              |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |

  Scenario Outline: A product can be added to the cart
    Given the user is logged in as "problem_user"
    When the user adds "<product>" to the cart
    Then the cart badge shows 1

    Examples: Products that can be added
      | product               |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
      | Sauce Labs Onesie     |

    @known_defect @DEF-03
    Examples: Products that cannot be added
      | product                           |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Test.allTheThings() T-Shirt (Red) |

  @known_defect @DEF-04
  Scenario: A product can be removed from the product list
    Given the user is logged in as "problem_user"
    And the user has added "Sauce Labs Backpack" to the cart
    When the user removes "Sauce Labs Backpack" from the product list
    Then the cart badge shows 0

  @known_defect @DEF-05
  Scenario Outline: Opening a product shows its details
    Given the user is logged in as "problem_user"
    When the user opens the details of "<product>"
    Then the product details show "<product>" priced at "<price>"

    Examples: Opens a different product
      | product               | price |
      | Sauce Labs Bike Light | $9.99 |

    Examples: Opens the item not found page
      | product                  | price  |
      | Sauce Labs Fleece Jacket | $49.99 |