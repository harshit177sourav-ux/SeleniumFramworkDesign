@tag
  Feature: Purchase the order from Ecommerce Website

    Background:
      Given I landed on Ecommerce Page

    @tag
    Scenario Outline: Positive Test for Submitting the Order

      Given Logged in with username <name> and password <password>
      When I add product <productName> to cart
      And Checkout <productName> and submit the order
      Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

      Examples:
      |name|password|productName|
      |DemoFNLN@gmail.com|Hars17hit@|ZARA COAT 3|