Feature: Create a deal
  I want to use the Clark platform to create and verify a peronal liability deal

  Background: 
    Given the user is logged on the staging environment of the Clark

  @offer @e2e
  Scenario Outline: Create and verify a recommended personal liability deal
    When the user is on the Contracts page of the application
    And the user click on the "Angebote" option
    And the user selects "Privathaftpflicht" insurance
    Then the user should be able to verify following default data on Deine Angaben Page
      | Familienstatus | im öffentlichen Dienst beschäftigt | in Rente | Selbstbeteiligung |
      | Single         | Nein                               | Nein     | Nein              |
    When the user selects recommended offer by clicking on "Jetzt abschließen" button
    And the user register through email and password
    Then the user should be able to fill personal information
      | Anrede | Vorname | Nachname | Geburtsdatum | Straße | Hausnr. | PLZ   | Ort    | Telefonnummer |
      | Herr   | Saurabh | Piyush   | 02.11.1989   | Park   |      10 | 11001 | London |  015229320777 |
    When the user selects the following options for "<Gewünschter Versicherungsbeginn>" and "<Vorschäden>"
    And the user enters the "<bankaccount number>"
    Then the user should be able to view Summary Page which starts from the  following confirmation message
    |Mit Klick auf “Jetzt abschließen” bestätige ich das|
    When the user choose to view contract overview by clicking on "Zur Vertragsübersicht" button
    Then the user should be able to view the correct contract on the "app/manager" route

    Examples: 
      | bankaccount number     | Gewünschter Versicherungsbeginn | Vorschäden |
      | DE55500105174529223988 | Nächster Werktag                | Nein       |

