# Test Automation Framework with BDD

This is a UI automation framework for DemoQA using Selenium WebDriver.

It supports both TestNG and Cucumber (BDD) execution and is built using Page Object Model with logging, hooks, and listeners.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Cucumber JVM
- Maven
- Log4j2

## Project Structure
- pages – Page Objects
- tests – TestNG tests
- cucumber – Step definitions, hooks, runner
- features – Gherkin feature files

## How to Run

### TestNG
Run `testng.xml`

### Cucumber
Run `CucumberRunner` class

## Features
- Page Object Model
- WebDriver wrapper/decorator
- Explicit waits
- Logging (Log4j2)
- Cucumber BDD support
- Scenario Outline with Examples
- Hooks (Before/After)
- Screenshot on failure

## Example Scenario
```gherkin
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