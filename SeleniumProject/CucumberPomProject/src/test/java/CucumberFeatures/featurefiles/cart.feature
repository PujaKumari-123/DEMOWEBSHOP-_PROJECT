@tag
Feature: Cart Functionality

  @Carts
 Scenario: Add a product to the cart 
  Given User is on the homepage  
  When User searches for Laptop  
  And User clicks on the first product  
  And User clicks on Add to Cart  
  Then The product should be added to the cart  
  And The cart count should increase 
   
Scenario: Remove a product from the cart  
  Given User has a product in the cart  
  When User navigates to the cart  
  And User clicks on Remove for the product  
  Then The product should be removed from the cart  
  And The cart count should decrease  
  
Scenario: Update product quantity in the cart  
  Given User has a product in the cart  
  When User navigates to the cart  
  And User changes the quantity of the product to two  
  And User clicks on Update Cart  
  Then The cart should reflect the updated quantity  
  And The total price should be updated accordingly  

Scenario: Verify empty cart message  
  Given User has an empty cart  
  When User navigates to the cart  
  Then A message Your cart is empty should be displayed  

Scenario: Proceed to checkout from the cart  
  Given User has a product in the cart  
  When User navigates to the cart  
  And User clicks on Proceed to Checkout  
  Then The checkout page should be displayed  