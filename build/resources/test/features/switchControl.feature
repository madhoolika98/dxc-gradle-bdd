@switchControl
Feature: Switching Control

  Background:
    Given Navigated to the DXC Homepage

  Scenario:Switch control between tabs and windows
    When In Home Page search for Customer
    Then Add new tab and navigate to Insurance Software and BPS Page
    And Verify subscribe now link is displayed
    Then Close the Insurance Software and BPS tab
    When Add new window and navigate to Customer Stories Page
    And Verify American Airlines is displayed
    Then Close Customer Stories Window
