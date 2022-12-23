@awardAndRecognition
Feature: Award and Recognition

  Background:
    Given Navigated to the DXC Homepage

  Scenario Outline:
    When Navigated to Awards and Recognition Page
    Then Search for the award "<Award Description>"
    Examples:
    |Award Description|
    |2021 Business Applications Inner Circle|
    |Excellence in New Business Development|
