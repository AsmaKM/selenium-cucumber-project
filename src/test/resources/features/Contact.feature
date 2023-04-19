Feature: Contact Form Test
  Scenario: Fill Up the contact form and submit it
    Given I go to Login page
    When I try to login with valid credentials
    Then I am logged in
    And I go to Contact Us Page
    And I fill the form with name :"asma", email:"asmaqac@gmail.com", subject: "testing" and message: "test" and submit it
