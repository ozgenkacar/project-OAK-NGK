Feature: Checkout the product which is at the cart

  As a Swag Labs customer I want to checkout products which is at the my cart

  Background:
    Given user is on the login page
    Then user logs in as "standard"
    And user verifies that "Swag Labs" page title is displayed
    Then user click add to cart button to buy "Sauce Labs Fleece Jacket"
    Then user click cart icon
    Then user click checkout button

  Scenario: user try to checkout without enter info
    Then user click continue button
    Then user get error message

  @cancelCheckout
  Scenario: user cancel the checkout process
    Then user enter "ozgen" as a firstname
    Then user enter "kacar" as a lastname
    Then user enter "07005" as a postal-zip code
    Then user click cancel button

  @checkout
    Scenario: user checkout the product
      Then user enter "ozgen" as a firstname
      Then user enter "kacar" as a lastname
      Then user enter "07005" as a postal-zip code
      Then user click continue button
      Then user click finish button
      Then user verify that "THANK YOU FOR YOUR ORDER" message displayed

Scenario: user check the product price if it is correct or not
  Then user enter "ozgen" as a firstname
  Then user enter "kacar" as a lastname
  Then user enter "07005" as a postal-zip code
  Then user click continue button
  Then user check that the product price is "$49.99" at the payment tab

  Scenario: user cancel checkout at the last step
    Then user enter "ozgen" as a firstname
    Then user enter "kacar" as a lastname
    Then user enter "07005" as a postal-zip code
    Then user click continue button
    Then user click cancel button