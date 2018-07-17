Feature: End-of-year bonus allocation

#  Managers get 20% of their salary, capped at 50K; Lab rats get 10%.

  Scenario: calculate bonuses
    Given A manager with a salary of 100,000
    And A lab rat with a salary of 5,000,000
    When the bonus are calculated
    Then a manager gets 20,000 bonus
    And a lab rat gets 500,000 bonus









  Scenario Outline: calculate bonuses 2
    Given A <job> with a salary of <salary>
    When the bonus are calculated
    Then a <job> gets <bonus> bonus
    Examples:
      | job     | salary    | bonus   |
      | manager | 50,000    | 10,000  |
      | lab rat | 50,000    | 5,000   |
      | lab rat | 1,000,000 | 100,000 |
      | manager | 250,000   | 50,000  |
      | manager | 350,000   | 50,000  |


