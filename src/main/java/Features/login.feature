@FunctionalTest
Feature: Let's Shop Login Feature

  #Without Examples Keyword
 # @SmokeTest
 # Scenario: Let's Shop Login Test Scenario
  #  Given User is already on Login Page
  #  When Title of Login Page is Let's Shop
  #  Then User enters "hs@gmail.com" and "Anish29@"
  #  Then User clicks on Login button
  #  And User is on Home Page

#With Examples Keyword(Data Driven Testing Approach)
  #@SmokeTest
 # Scenario Outline: : Let's Shop Login Test Scenario
   # Given User is already on Login Page
   # When Title of Login Page is Let's Shop
   # Then User enters "<userName>" and "<password>"
   # Then User clicks on Login button
   # And User is on Home Page

   # Examples:
  #  | userName | password |
  #  | hs@gmail.com | Anish29@ |
  #  | as@gmail.com | Anish29@ |


    #With Data Tables Approach(Data Driven testing)
  #@SmokeTest
  #Scenario:  Let's Shop Login Test Scenario
   # Given User is already on Login Page
   # When Title of Login Page is Let's Shop
  #  Then User enters userName and password
   #   | hs@gmail.com | Anish29@ |
   # Then User clicks on Login button
   # And User is on Home Page


      #With Data Tables Approach(Data Driven testing)
  @SmokeTest @RegressionTest
  Scenario:  Let's Shop Login Test Scenario
    Given User is already on Login Page
    When Title of Login Page is Let's Shop
    Then User enters userName and password
      | userName | password |
      | hs@gmail.com | Anish29@ |
    Then User clicks on Login button
    And User is on Home Page

