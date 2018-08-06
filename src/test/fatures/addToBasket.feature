Feature:basket functionality

  I would like to add item to the basket in amazon website
  so that i can add the item

  Scenario Outline: add to basket
    Given I am on the home page
    When I search for the "<product>"
    Then the result should be shown
    When I select the first product
    Then I should navigate to detailed page
    When I click on add to basket
    Then the item should be add to the basket

    Examples:
      |product|
      |  sony |
