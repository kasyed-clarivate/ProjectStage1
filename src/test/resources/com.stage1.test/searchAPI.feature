@api
Feature: As a API user, I want to check all the web services requests are correctly processed so I can use the site confidently


  Scenario: User sends the request by calling search service api
    Given John has search-string to search for search service
    When he kicks off the search
    Then he gets 200 status code


  Scenario: User requests for sepcefic category reference to category service
    Given John has category reference number to request
    When he kicks off the request with that category reference
    Then he gets 200 status code


  Scenario: User requests for sepcefic product listing to Product-Listing service
    Given John has product listing reference number to request
    When he kicks off the request with that listing reference
    Then he gets 200 status code
