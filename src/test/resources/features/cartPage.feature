Feature: Manage shopping cart

  As a Swag Labs customer I want to manage products which is in my cart In order to buy them

  Background:
    Given user is on the login page
    Then user logs in as "standard"
    And user verifies that "Swag Labs" page title is displayed
    Then user click add to cart button to buy "Sauce Labs Fleece Jacket"
    Then user click cart icon


  Scenario: user remove product from the cart
    Then user see 1 item on the cart
    Then user click remove button for 1 item

  Scenario: user click checkout button
    Then user click checkout button
  