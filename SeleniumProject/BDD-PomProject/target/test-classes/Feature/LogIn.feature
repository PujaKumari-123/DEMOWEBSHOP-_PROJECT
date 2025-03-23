Feature: To Check login 
  Scenario: Checking functionality of Login Demo Web Shop Application
    Given Users Open chromebrowser and put on Url
    When Users click on Login
    And Users put on Email id, Password and click on Remember me checkbox
    Then Users click on Login button
   
  Scenario: Checking functionality of Login with Invalid Credentials
    Given Users Open Chrome browser and put on URL
    When Users click on Login
    And Users enter invalid Email ID or incorrect Password
    Then Users click on Login button
    And Users should see a login error message
    Then Users close the browser 