Feature: travel from to a station

  Scenario: travel from Amsterdam to Utrecht
    Given I am at www.ns.nl
    And I clicked accept in cookie popup
    And I choose to travel today
    And I travel from Amsterdam
#    And I travel to Ut recht



#    Then I find result

  Scenario: 2 travel from Amsterdam to Utrecht
    Given I am at www.ns.nl
    And I clicked accept in cookie popup
    And I choose to travel today