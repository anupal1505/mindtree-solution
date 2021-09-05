Feature: I want to test ANZ Bank calculator

  Scenario: Check loan eligibility for single user
    Given bankuser chooses Single option
		And bankuser doesnt not have dependents
    When bankuser is choosing home for self living
    And bankuser infomartion about earnings-expenses and submits details
    Then bankuser is shown his loan eligibility amount