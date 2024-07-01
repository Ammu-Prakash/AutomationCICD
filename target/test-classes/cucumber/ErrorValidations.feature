
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @Error
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name                  | password   | 
      | zimbacookie@gmail.com | Zoyass@123 | 
      
      



