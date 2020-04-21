@Foriegn
Feature: Check the rates

  @rate
  Scenario: Check the rates for Specific Date and Speicific Base value
    When I make a request with "2010-01-12" Date and Base "USD"
  #  And I got the response and validating with below parameters
  #    | rates.USD |     1.4481 |
  #    | date      | 2010-01-12 |
    When I make a request with LatestDate and Base "USD"
   
