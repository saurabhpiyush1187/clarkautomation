Feature: Create a deal
  I want to use the Clark platform to verify top menu options for contracts page
  
 Background:
 Given the user is logged on the staging environment of the Clark

  @contracts
  Scenario: Verify top menu items
    When the user is on the Contracts page of the application
    Then the following menu options should be available on the page
    |Verträge|
    |Bedarf|
    |Rente|
    |Angebote|

