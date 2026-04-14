Feature: Login functionality

  Background:
    Given User opens login page

  Scenario Outline: Login with multiple users
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks login button
    Then User should see dashboard

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |