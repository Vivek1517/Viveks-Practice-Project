
Feature: Newsletter
  Scenario Outline: verify user is able to subscribe by providing valid email address
    Given user is on automation practice app
    When user enters valid email "<email>"
    Then user should see a message "<message>"
    Examples:
      | email               | message                                                           |
      | rttrete@hotmail.com | Newsletter : You have successfully subscribed to this newsletter. |

@negativeScenario
  Scenario Outline: verify user is not able to subscribe by providing invalid email address
    Given user is on automation practice app
    When user enters valid email "<email>"
    Then user should see a news letter error message "<message>"
    Examples:
      | email              | message                             |
      | rttretehotmail.com | Newsletter : Invalid email address. |
