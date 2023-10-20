@regression
Feature: Purchasing Products on Saucedemo Website
  @Checkout
  Scenario: Purchase a Product
    Given User opens the Saucedemo website
    When User logs into Saucedemo
    And User adds a product to the cart
    Then User verifies that the product has been added to the cart
    And User proceeds to checkout
    And User enters shipping information
    And User clicks the Continue button
    Then User verifies that the product is correct on the overview page
    And User clicks the finish button
    Then User verifies that the order complete message is displayed
