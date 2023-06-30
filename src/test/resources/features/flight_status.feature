Feature: Our website users should be able to get the flights status of a given flight route by a given date

  Background:
    Given Sergio is looking for Eurowings flights status

  Scenario Outline: Flight routes from a departure airport to a destination airport with different travel dates are shown with the selected dates
    Given he is going from "<departureAirport>"
    And he is going to "<destinationAirport>"
    And he is travelling "<travelDate>"
    When he looks for the flights routes status
    Then all the flights routes status are shown for the given date

    Examples:

      | departureAirport | destinationAirport | travelDate |
      | CGN              | BER                | today      |
      | CGN              | BER                | tomorrow   |
      | CGN              | BER                | 2023-07-02 |
