@Personal
Feature: Personal Information

  Scenario Outline: verify a registered user is able to change password using personal information link
    Given user is on automation practice app
    When user clicks on sign in
    Then user should be on authentication page
    When user enters email "<email>"
    And user enters password "<password>"
    And user clicks on sign in
    Then user should navigate to my account page
    When user clicks on my personal information
    Then user shoud navigate to your personal information page
    When user enters current password "<current_password>"
    And user enters new password "<new_password>"
    And user enters in the confirmation field "<confirm_password>"
    And user clicks on save
    Then user should see a succesful validation message"<validation_message>"
    Examples:
      | email                  | password | current_password | new_password | confirm_password | validation_message                                       |
      | vick_sturd@hotmail.com | Vivek123 | Vivek123         | Vivek321     | Vivek321         | Your personal information has been successfully updated. |
