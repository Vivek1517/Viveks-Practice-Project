@Regression
Feature: Search field

  Scenario Outline: Verify user is not able to search product if it isnt available using search field box
    Given user is on automation practice app
    When user searches for product "<product_Name>" in the search field
    And user clicks on search
    Then user should see an error message "<error>"
    Examples:
      | product_Name | error                                        |
      | jeans        | No results were found for your search jeans  |
      | skirts       | No results were found for your search skirts |

    Scenario: Verify user is able to search available product using search field box
      When user searches for product "skirt" in the search field
      And user clicks on search
      Then user should navigate to the product page

