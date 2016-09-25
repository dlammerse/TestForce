Feature: travel from to a station

  Scenario: travel from Amsterdam to Utrecht
    Given I am at www.ns.nl
    And I clicked accept in cookie popup
    When I choose to travel today
#    And I travel to Utrecht
#    Then I find result