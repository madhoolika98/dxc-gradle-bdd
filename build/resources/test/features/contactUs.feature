@contactUs
Feature: Contact Us Page

  Background:Navigating to DXC Homepage
    Given Navigated to the DXC Homepage

  Scenario:Contact Us for a new User
    When Clicked on the contact us option
    Then The Home Page is redirected to Contact Us Page
    When Added Information regarding a Sales Query
    |First Name|Last Name|Email              |Telephone |Organization                                 |Contact With|Country  |Comment              |
    |Frank     |Finn     |frank.fin@gmail.com|1234567891|DXC TECHNOLOGY INDIA PRIVATE LIMITED         |Sales       |India    |Query regarding sales|
    Then Verify the Submit Button is enabled