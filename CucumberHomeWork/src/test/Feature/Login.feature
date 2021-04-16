Feature: Login feature

  Background:
    Given user is on automation practice app
    When user clicks on sign in
    Then user should be on authentication page

  Scenario: Verify user is able to login using valid credentials
    When user enters email "vicky_sturd@hotmail.com"
    And user enters password "Vivek123"
    And clicks on sign in
    Then user should navigate to my account page


    Scenario Outline: Verify user is not able to login using invalid credentials
      When user enters email "<email address>"
      And user enters password "<password>"
      And clicks on sign in
      Then user should see a validation message "<error_message>"

      Examples:
        | email address           | password | error_message          |
        | vicky_sturd@hotmail.com | vivek123 | Authentication failed. |