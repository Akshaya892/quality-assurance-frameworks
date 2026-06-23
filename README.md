# Selenium Cucumber Automation Framework

A test automation framework built using Java, Selenium WebDriver, Cucumber BDD, Maven, JUnit, and Allure Reporting.
Created for learning and practicing Selenium Automation Framework development using industry-standard design patterns and reporting tools.

## Tech Stack

- Java 
- Selenium WebDriver 
- Cucumber 
- JUnit 
- Maven
- Allure Reporting
- IntelliJ IDEA

## Framework Components

### DriverFactory

Responsible for:

- Browser initialization
- Driver management
- Browser termination

### Page Objects

Implements Page Object Model (POM).

Example:

- LoginPage
- RegistrationPage

### Step Definitions

Maps Gherkin steps to Selenium code.

Example:

```gherkin
Given User is on Login Page
When User enters username as "admin"
Then User should be redirected to Dashboard
```

### Hooks

Contains:

- @Before
- @After

Used for:

- Browser setup
- Browser cleanup

### Utilities

Reusable helper classes:

- Screenshot Utility
- Wait Utility

---

## Features Implemented
- Open browser
- Fill registration form
- Submit form
- Verify submission

### Explicit Waits

Implemented using WebDriverWait to handle dynamic web elements.

---

## Running Tests

Run using IntelliJ:

```text
Right Click TestRunner
→ Run TestRunner

### Generate Report
allure generate allure-results --clean -o allure-report

### Open Report
allure open allure-report

## Sample Execution Flow

```text
TestRunner
    ↓
Feature File
    ↓
Step Definition
    ↓
Page Object
    ↓
Selenium Actions
    ↓
Validation
    ↓
Allure Report

## Design Patterns Used

- Page Object Model (POM)
- Factory Pattern (DriverFactory)
- BDD (Behavior Driven Development)
- Object-Oriented Programming


