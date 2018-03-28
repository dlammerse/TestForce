Feature: travel from to a station

  Scenario: travel from Amsterdam to Utrecht
    Given I am at www.ns.nl
    And I clicked accept in cookie popup
    And I choose to travel today
    And I travel from Amsterdam
    And I travel to Utrecht
    And I set Class
    And no of pessengers

    And I set Initials
    And I set Surname
    And Set date of birth
    And Set date Month
    And Set date Year
    And Set Email address
    And Add to shoppingcard
    And verify price




#    Then I find result

  Scenario: 2 travel from Amsterdam to Utrecht with children
    Given I am at www.ns.nl
    And I clicked accept in cookie popup
    And I choose to travel today
