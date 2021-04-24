Feature: Log in feature for automation practice app
  Background:
    Given user is on automation practice
    When user clicks on sign in
    Then user should navigate to authentication page

    Scenario Outline: verify user is able to log in using valid credentials
      When user enters email "<email>" and password "<pwd>"
      And user clicks on log in
      Then user should navigate to my account page

      Examples:
        | email                   | pwd      |
        | vicky_sturd@hotmail.com | Vivek123 |

     Scenario Outline: verify user is not able to log in using invalid credentials
       When user enters email "<email>" and password "<pwd>"
       And user clicks on log in
       Then user should see an error "<validation_message>"
       Examples:
         | email                   | pwd      | validation_message         |
         | vicky_sturd@hotmail.com |          | Password is required.      |
         |                         | Vivek123 | An email address required. |
         | vicky_sturd@hotmail.com | vivek123 | Authentication failed.     |
         | vicky_sturdhotmail.com  | vivek321 | Invalid email address.     |

