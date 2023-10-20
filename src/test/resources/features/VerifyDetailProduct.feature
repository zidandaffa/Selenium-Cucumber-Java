@regression @VerifyProduct
Feature: Product Details

  Background:
    Given User is on the Saucedemo website
    And User is logged in

  Scenario: View Product Details
    When User clicks on a product
    Then User should see the Product Details page
    And Product name should be "Sauce Labs Backpack"
    And Product description should be "A comfortable and stylish backpack made of high-quality materials."
    And Product price should be "$29.99"