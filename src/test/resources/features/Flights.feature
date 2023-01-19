@Flights
Feature: Kayak Dashboard

  Scenario: Verify Dashboard side panel menu items loads properly
    Given user is on the login page
    When I go to the "Flights" page
    And I "should" see "Where are you flying?" page title
    Then I "should" see "Kayak" page title
    And I "should" see "burger type" button on side panel
    And I should be able to see side panel pages
      | Sign in             |
      | Flights             |
      | Stays               |
      | Cars                |
      | Packages            |
      | Trains and buses    |
      | Explore             |
      | Flight Tracker      |
      | Travel Restrictions |
      | Trips               |
    And I should be able to see side panel page icons
      | flights             |
      | hotels              |
      | cars                |
      | find packages       |
      | find trains         |
      | explore kayak       |
      | travel restrictions |
      | trips               |
    When I click "burger type" button
    Then Verify side panel is "close"
    And I should not be able to see side panel pages
    And I should be able to see side panel page icons
      | flights             |
      | hotels              |
      | cars                |
      | find packages       |
      | find trains         |
      | explore kayak       |
      | travel restrictions |
      | trips               |
    When I hover over to "Flights" icon
    Then Verify side panel is "open"
    And I should be able to see side panel pages
      | Sign in             |
      | Flights             |
      | Stays               |
      | Cars                |
      | Packages            |
      | Trains and buses    |
      | Explore             |
      | Flight Tracker      |
      | Travel Restrictions |
      | Trips               |