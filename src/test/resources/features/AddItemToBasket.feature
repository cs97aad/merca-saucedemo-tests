Feature: As a user,
  I want to add the highest price item to the cart

  Scenario: Add the selected highest price item to the cart
    Given I am on the landing page
    When I login using details username "standard_user" and password "secret_sauce"
    Then product page is displayed
    And I add the highest price item to the cart by clicking its Add to Cart button
    And the Add to Cart button changes to Remove button
    And I navigate to the cart page