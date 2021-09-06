Feature: I want to test ANZ Bank calculator

  Scenario: Check loan eligibility for single user
    Given bankuser1 logs to ANZ site and chooses Single option
		And bankuser1 does not have dependents
    When bankuser1 is choosing home for self living
    And bankuser1 fills information about earning-expenses and submits detail
    Then bankuser1 is shown his loan eligibility amount
    
    Scenario: Click the startover button clears the form
    Given bankuser2 logs to ANZ site and fills all details
    When Order has already submitted and Loan eligibility amount has been calculated
    And bankuser2 clicks on startover button
    Then All the values are cleared
    
     Scenario: Verify user gets error message when it only fills Living Expenses
     Given bankuser3 logs to ANZ site
    When bankuser only fills living expenses and submit the application
    Then bankuser receives error message
    