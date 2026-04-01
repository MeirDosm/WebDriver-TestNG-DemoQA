# Test Automation Framework Updates

## Design Patterns Implemented
- **Singleton:** `DriverManager` ensures one WebDriver instance.
- **Factory Method:** `DriverFactory` creates browser-specific drivers.
- **Decorator:** `WebDriverDecorator` and `WebElementDecorator` add logging, highlighting, and screenshot support.

## Framework Features
- Page Object Model
- Logging and element highlighting
- Screenshot support
- Config-based environment setup

## Test Results
- ✅ All tests pass: `ButtonsTest`, `CheckboxTest`, `TextBoxTest`

## Notes
- Code follows S.O.L.I.D. principles