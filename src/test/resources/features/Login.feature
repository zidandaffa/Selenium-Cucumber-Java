@regression
Feature: Login

  @Login1 @Positive
  Scenario: Login
    Given User is on login page
    When User fill username and password
    And User click login button
    Then User verify login result

  @Login2 @Negative
  Scenario: Login invalid Password
    Given User is on login page
    When User fill password but invalid username
    And User click login button
    Then User get error username password not match

