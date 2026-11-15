@logout
Feature: Logout from the store
  As a logged-in shopper
  I want to log out of my session
  So that nobody else can use my account

  @smoke
  Scenario: Logout from the products page
    Given the user is logged in as "standard_user"
    When the user logs out
    Then the login page is displayed