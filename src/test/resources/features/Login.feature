Feature: Login
  Scenario: Successful Login
    Given I go to Login page
    When I try to login with username:"asmaqac@gmail.com" and password: "qaconsultants"
    Then I am logged in



  Scenario: UnSuccessful Login
    Given I go to Login page
    When I try to login with wrong username:"asmaqa@gmail.com" and password: "qac"
    Then I am not logged in