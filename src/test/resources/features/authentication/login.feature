@login
Feature: Login to the store
  As a registered shopper
  I want to log in with my credentials
  So that I can access the product catalog

  @smoke
  Scenario: Login with a valid user
    Given the user is on the login page
    When the user logs in as "standard_user" with password "secret_sauce"
    Then the products page is displayed

  Scenario: Login with a locked out user
    Given the user is on the login page
    When the user logs in as "locked_out_user" with password "secret_sauce"
    Then the error message "Epic sadface: Sorry, this user has been locked out." is displayed

  Scenario Outline: Login with invalid or missing credentials
    Given the user is on the login page
    When the user logs in as "<username>" with password "<password>"
    Then the error message "<message>" is displayed

    Examples:
      | username      | password     | message                                                                   |
      | invalid_user  | wrong_pass   | Epic sadface: Username and password do not match any user in this service |
      | standard_user | wrong_pass   | Epic sadface: Username and password do not match any user in this service |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user |              | Epic sadface: Password is required                                        |