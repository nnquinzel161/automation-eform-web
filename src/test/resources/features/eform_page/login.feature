Feature: Login Web
  As a User,
  I want to be able to login
  So that I can access menus in the web

  @login
  Scenario: Login success using correct username and password
    Given User navigate to Eform login page
    When User enters a valid username
    And User enters a valid password
    And User click login
    Then User should be navigated to Eform dashboard