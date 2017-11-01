@ui
Feature: As a GUI user, I want to check all the dom elements are correctly rendered on the respective page so I can use site confidently


  Scenario: Should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product from the input box
    Then the result should be displayed


  Scenario: Should be able to search for a product from the drop-down menu
    Given John is viewing the Etsy landing page
    When he chooses clothing and dresses from drop-down menu
    Then the breadcrumb for "Dresses" should be displayed


  Scenario: Should be able to search for a product from the icons
      Given John is viewing the Etsy landing page
      When he clicks on first popular product icon
      Then the same product item description should be displayed on Product page

