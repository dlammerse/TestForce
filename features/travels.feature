Feature: travel from to a station

  Scenario: Form should be completely filled
    Given I am at www.ns.nl
    And I clicked accept in cookie popup
    And I choose to travel today
    And I travel from Amsterdam
    When I have clicked on InWinkelwagen
    Then an error should be shown



  ##### Opdrachten #####
  # Boek een reis voor 1 persoon
  #   Boek een enkele reis van Utrecht naar Amsterdam in de 1e klas voor J.M. Veenstra (geboren op 02-06-1968) voor E 12,80

  # Kan ik een boeking wijzigen:
  #   Boek een enkele reis van Etten-Leur naar Rotterdam voor 11,20. Maar wijzig de bestemming naar Roosendaal om te zien of de prijs wijzigd naar 3,10

  # Controleer berekeningen:
  #   Kosten voor een trip van Etten-Leur naar Rotterdam kost 11,20
  #   Kosten voor een trip van Etten-Leur naar Groningen kost 26,30
  #   Kosten voor een trip van Etten-Leur naar Roosendaal kost 3,10