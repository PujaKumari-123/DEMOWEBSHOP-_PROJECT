
@tag
Feature: Construct Week Project
  I want to use this template for my feature file

  @Testings
  
  Scenario: Categories
  
    Given User enters the browser and enter url

    When User clicks on Book
    
    And  Clicks on Computer
    
    And  Clicks on Electonics
    
    Then Url should change 
     
  
   Scenario: Search
  
    Given User enters the browser and enter url

    When User clicks on Search
    
    And Enters Invalid data 
    
    Then No Results should be visible
    
    
    Scenario: Links
  
    Given User enters the browser and enter url

    When User clicks on Register , Login, Shopping Cart , Wishlist
        
    Then New Page should be opened
    
    
    
     Scenario: Visibility
  
    Given User enters the browser and enter url

    When User scrolls down
        
    Then Featured Options should be visible
    
    
     Scenario: Tags Check 
  
    Given User enters the browser and enter url

    When User scrolls down 
    
    And Clicks on View all  
    
    Then List should be visible
    
    
    Scenario: Visibility
    
    Given User enters the browser and enter url

    When User scrolls down
        
    Then Customer Service should be visible
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    