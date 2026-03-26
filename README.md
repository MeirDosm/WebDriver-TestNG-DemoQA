# Test Automation Framework

Test Automation Framework for [DemoQA](https://demoqa.com) using Java, Selenium WebDriver, and TestNG.  
Supports multiple browsers, environments, logging, screenshots on failure, smoke & regression suites.

## Technologies
Java | Selenium WebDriver | TestNG | Maven | Log4j2 | WebDriverManager

## Features
- Page Object Model
- Environment configs via property files
- Smoke & Regression suites
- Screenshots on test failure
- Logging & element highlighting

## Run Tests
Smoke: `mvn test -DsuiteXmlFile=smoke.xml`  
Regression: `mvn test -DsuiteXmlFile=regression.xml`

## Logs & Screenshots
Logs → `logs/`  
Screenshots → `screenshots/` (only on failures)