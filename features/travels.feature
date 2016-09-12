Feature: travel from to a station

  Scenario: one traveller
    Given I am at NS website for "enkele-reis"
    And I clicked accept in cookie popup
    And I fill "Utrecht" as the station Vanaf
    And I choose to travel on "25-09-2016"
    And I fill "Amsterdam" as the station Naar
    And I select "1e" as the Klasse
    And I select "1" as the number of Reizigers
    And I fill "J.M." as the first initials
    And I fill "Veenstra" as the first name
    And I fill "02-06-1968" as the first Birth date
    When I have clicked on InWinkelwagen
    Then the total price is "12,80"

   Scenario: travel with two children
     Given I am at www.ns.nl
     And I clicked accept in cookie popup
     And I choose to travel today
     And I fill "Utrecht" as the station Vanaf
     And I fill "Amsterdam" as the station Naar
     And I select "1e" as the Klasse
     And I select "1" as the number of Reizigers
     And I fill initials "J.J.G.W.M." for traveller "1"
     And I fill name "Bakker" for traveller "1"
     And I fill birth date "22-11-1988" for traveller "1"
     And I have clicked on InWinkelwagen
     And I have clicked on Railrunner
     And I have clicked on DirectBestellen
     And I fill to travel today
     And I select "2" as the number of Children
     And I fill "J." as the first child initials
     And I fill "Bakker" as the first child name
     And I fill "22-11-2010" as the first child Birth date
     And I fill "R." as the second child initials
     And I fill "Bakker" as the second child name
     And I fill "02-03-2009" as the second child Birth date
     When I have clicked on KidsInWinkelwagen
     Then the total price is "17,80"

  Scenario: Two adults and two kids
    Given I am at www.ns.nl
    And I clicked accept in cookie popup
    And I choose to travel today
    And I fill "Breda" as the station Vanaf
    And I fill "Amsterdam" as the station Naar
    And I select "1e" as the Klasse
    And I select "2" as the number of Reizigers
    And I fill "W.M." as the first initials
    And I fill "Boer" as the first name
    And I fill "03-08-1991" as the first Birth date
    And I fill email address "willem.de.boer@test.nl" for traveller "1"
    And I fill initials "C." for traveller "2"
    And I fill "Boer" as the second name
    And I fill "30-03-1993" as the second Birth date
    And I fill "corrie.de.boer@test.nl" as the second email address
    And I have clicked on InWinkelwagen
    And I have clicked on Railrunner
    And I have clicked on DirectBestellen
    And I fill to travel today
    And I select "2" as the number of Children
    And I fill "Q." as the first child initials
    And I fill "Boer" as the first child name
    And I fill "04-09-2010" as the first child Birth date
    And I fill "A.M." as the second child initials
    And I fill "Boer" as the second child name
    And I fill "12-04-2009" as the second child Birth date
    When I have clicked on KidsInWinkelwagen
    Then the total price is "73,40"

  Scenario: all directions
    Given I travel today from "Etten-Leur"
    When I'm going to "Rotterdam"
    Then the total price is "11,10"

    When I change the destinity into "Roosendaal"
    Then the total price is "3,10"

    When I change the destinity into "Utrecht"
    Then the total price is "17,20"

    When I change the destinity into "Groningen"
    Then the total price is "26,30"

   Scenario Outline: Check travel table
     Given I'm travelling today from "Etten-Leur"
     When I travel to "<toStation>"
     Then I have to pay "<totalPrice>"
     Examples:
     | toStation  | totalPrice |
     | Rotterdam  | 11,10      |
     | Groningen  | 26,30      |
     | Roosendaal | 3,10       |

   Scenario: Check travelling from table
     Given I'm travelling today from "Etten-Leur"
     Then I select a destination and check the totalPrice:
     | destination | totalPrice |
     | Rotterdam   | 11,10      |
     | Utrecht     | 17,20      |
     | Roosendaal  | 3,10       |
     | Maastricht  | 22,90      |
     | Groningen   | 26,30      |

   Scenario: Schoolreisje
     Given travelling today "retour"
     And I fill "Breda" as the station Vanaf
     And I fill "Amsterdam" as the station Naar
     And I select "2e" as the Klasse
     And we travel with the following adults:
     | initials | name            | birth date | email address                  |
     | W.M.     | Boer            | 03-08-1991 | willem.de.boer@test.nl         |
     | C.       | van der Bruggen | 30-03-1993 | corrie.van.der.bruggen@test.nl |
     | W.       | Keizer          | 30-03-1993 |                                |
     | J.       | Bakker-Boer     | 06-12-1993 | jannie.bakker@test.nl          |
     And we travel with the following kids:
     | initials | name            | birth date |
     | J.M.     | van Tilburg     | 16-01-2010 |
     | R.H.     | Koot            | 07-11-2009 |
     | N.       | Brink           | 30-03-2010 |
     | P.       | Henegouwen      | 23-06-2011 |
     | Y.       | Kapitein        | 16-01-2010 |
     | B.M.H.   | de Koning       | 07-11-2009 |
     | J.       | de Graaf        | 30-03-2010 |
     | F.M.     | el Amahni       | 23-06-2011 |
     | M.       | Jackson         | 16-01-2010 |
     | L.       | de Leeuw        | 18-12-2009 |
     When I have clicked on KidsInWinkelwagen
     Then the total price is "185,80"

     Scenario: AA Reisverzekering
     Given I'm on ABN Amro site
     And I have accepted AA cookies
     And I have selected Menu "Verzekeren"