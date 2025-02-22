
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce page

  @Smoke
  Scenario Outline: Positive test of submitting an order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page

    Examples: 
      | name                  | password | productName  |
      | zimbacookie@gmail.com | Zoya@123 | ZARA COAT 3  |
     
