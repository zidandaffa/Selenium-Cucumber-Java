@regression
Feature: Filtering Products

  @fillter1
  Scenario: User can filter products by name (A to Z)
    Given the user is on the Saucedemo website
    When the user logs in with the username "standard_user" and the password "secret_sauce"
    And the user selects Name (A to Z) from the filter dropdown
    Then the products are displayed according to the Name (A to Z) filter: Sauce Labs Backpack, Sauce Labs Bike Light, Sauce Labs Bolt T-Shirt
  @fillter2
  Scenario: User can filter products by name (Z to A)
    Given the user is on the Saucedemo website
    When the user logs in with the username "standard_user" and the password "secret_sauce"
    And the user selects Name (Z to A) from the filter dropdown
    Then the products are displayed according to the Name (Z to A) filter: Test.allTheThings() T-Shirt (Red), Sauce Labs Onesie, Sauce Labs Fleece Jacket