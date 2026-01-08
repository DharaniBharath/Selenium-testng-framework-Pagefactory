# Selenium TestNG Page Factory Hybrid Framework

This project is a **Hybrid Test Automation Framework** built using  
**Selenium WebDriver + TestNG + Page Factory + Maven + Allure Reporting**.

It follows industry best practices and is suitable for real-time automation projects.

---

## 🚀 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (Page Factory)
- Apache POI (Excel handling)
- Allure Reports
- Git & GitHub

---

## 📂 Framework Design

### 1️⃣ PageObjects
Path: `src/main/java/com/PageObjects`

Contains all application page classes using **Page Factory**.

Each page includes:
- WebElements using `@FindBy`
- Page-level actions (methods)

Example:
- `LoginPage.java`
- `HomePage.java`
- `RegisterPage.java`
- `SearchPage.java`

---

### 2️⃣ Test Data
Path: `src/main/java/com/testData`

- `TestDataProperties.java`  
  Handles reading test data from property files or Excel.

- `testdatafrom.xlsx`  
  Stores test input data (username, password, search text, etc.)

---

### 3️⃣ Utilities
Path: `src/main/java/com/utils`

- `Utility.java`  
  Contains reusable methods:
  - Screenshot capture
  - Wait methods
  - Browser utilities
  - Common helper functions

---

### 4️⃣ Test Base
Path: `src/test/java/com/testBase`

- `BaseTest.java`  
  - WebDriver initialization
  - Browser setup
  - URL launch
  - Test teardown
  - Common configuration handling

All test classes **extend BaseTest**.

---

### 5️⃣ Test Cases
Path: `src/test/java/com/testCases`

Contains actual TestNG test classes:
- `LoginTest.java`
- `RegisterTest.java`
- `SearchTest.java`

Each test:
- Uses Page Object methods
- Contains assertions
- Is independent and maintainable

---

### 6️⃣ Listeners
Path: `src/test/java/com/listeners`

- `MyListeners.java`
  - Implements TestNG listeners
  - Captures screenshots on failure
  - Integrates Allure reporting

---

### 7️⃣ TestNG XML Files
Path: `src/test/resources`

Used to control test execution:
- `login.xml`
- `register.xml`
- `search.xml`
- `*TestRun.xml`

Allows:
- Suite-level execution
- Parallel execution
- Group-based execution

---

### 8️⃣ Reports

#### 🔹 Allure Reports
- Raw data: `target/allure-results`
- HTML report: `Allure-HTML-Reports`

Command to generate report:
```bash
allure serve target/allure-results
