@api
Feature: As a API user, I want to check all the web services requests are correctly processed so I can use the site confidently


  Scenario: User sends the request by calling Search Service
    Given John has search-string to search for search service
    When he sends the search request
    Then he gets OK status along with expected response for "Search" service


  Scenario: User requests for sepcefic category reference to Category Service
    Given John has category reference number to request
    When he kicks off the request with that category reference
    Then he gets OK status along with expected response for "Category" service


  Scenario: User requests for sepcefic product listing to Product-Listing Service
    Given John has product listing reference number to request
    When he kicks off the request with that listing reference
    Then he gets OK status along with expected response for "Product-Listing" service
