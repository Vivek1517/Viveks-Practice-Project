@ContactUs
Feature: Contact us
  Scenario Outline: verify user is able to contact admin by filling in mandatory fields
    Given user is on automation practice app
    When user clicks on contact us link
    Then user should be navigated to contact us page
    When user selects "<subject_heading>"
    And user enters email "<email>"
    And user enters a message "<type_message>"
    And user clicks on send
    Then user should see a message "<message>"
    Examples:
      | subject_heading  | email          | message                                              | type_message   |
      | Customer service | djdk@gmail.com | Your message has been successfully sent to our team. | Hey Automation |

  Scenario Outline: verify user is not able to contact admin by not filling in mandatory field
    Given user is on automation practice app
    When user clicks on contact us link
    Then user should be navigated to contact us page
    When user selects "<subject_heading>"
    And user enters email "<email>"
    And user enters a message "<type_message>"
    And user clicks on send
    Then user should see a error message "<message>"
    Examples:
      | subject_heading  | email          | message                      | type_message |
      | Customer service | djdk@gmail.com | The message cannot be blank. |              |
