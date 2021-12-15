Feature: Login
  As a user, I want to be able to login into TradeSun
  under different roles with username and password

  Background:
    Given user is on the login page


  @login_as_standard_user
  Scenario: Login as standard user
    Then user logs in as "standard"
    And user verifies that "Swag Labs" page title is displayed

  @login_as_locked_user
  Scenario: Login as locked user
    Then user logs in as "locked"
    And user verifies that "Swag Labs" page title is displayed

  @login_as_problem_user
  Scenario: Login as problem user
    Then user logs in as "problem"
    And user verifies that "Swag Labs" page title is displayed

  @login_as_performance_user
  Scenario: Login as performance user
    Then user logs in as "performance"
    And user verifies that "Swag Labs" page title is displayed

  @login_with_role
  Scenario Outline: Login with role
    Then user logs in as "<role>"
    And user verifies that "Swag Labs" page title is displayed
    Examples:
      | role         |
      | standard     |
      | locked       |
      | problem      |
      | performance  |

  @error_message @wrongUsernameAndPassword
  Scenario: user gives invalid credentials and get error message
    Then user enters "wrongUsername" username and "wrongPassword" password
    Then user verifies that "Epic sadface: Username and password do not match any user in this service" error message is displayed

  @wrongPassword
  Scenario: user gives invalid password and get error message
    Then user enters "standard_user" username and "wrong-password" password
    Then user verifies that "Epic sadface: Username and password do not match any user in this service" error message is displayed

  @wrongUsername
  Scenario: user gives invalid username and get error message
    Then user enters "wrong-username" username and "secret_sauce" password
    Then user verifies that "Epic sadface: Username and password do not match any user in this service" error message is displayed
