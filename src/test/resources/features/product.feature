Feature: Add products to cart

  As a Swag Labs customer I want to add products to my cart In order to buy them

  Background:
    Given user is on the login page
    Then user logs in as "standard"
    And user verifies that "Swag Labs" page title is displayed

    Scenario: user can see items which are at the inventory
    Then user verify that 6 items at the inventory

    Scenario: user can get the list of items which are at the inventory
    Then user get list of all items at the inventory

    Scenario: user verify that item title is correct when click the item
      Then user verify that when select "Sauce Labs Backpack" title is same with fallowing page

    Scenario: user verify that item price is correct when click the item
      Then user verify that when select "Sauce Labs Bike Light" item price is same with fallowing page

    Scenario: user verify that item description is correct when click the item
      Then user verify that when select "Sauce Labs Bolt T-Shirt" item description is same with fallowing page

    Scenario: user able to add item to the cart
      Then user click add to cart button to buy "Sauce Labs Onesie"
      Then user verify that added to cart button at the "Sauce Labs Onesie" is clicked
