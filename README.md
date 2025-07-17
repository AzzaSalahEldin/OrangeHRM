# OrangeHRM Test Automation Framework

This is a Selenium-Cucumber-based test automation framework for validating key OrangeHRM functionalities like login, adding employees, and managing admin users. The framework uses the Page Object Model (POM) design pattern and includes Allure for reporting.

---

## 🛠 Tools & Technologies Used

| Tool              | Description                                          |
|------------------|------------------------------------------------------|
| Java (JDK 11+)    | Programming language for automation                 |
| Maven             | Build and dependency management tool                |
| Selenium WebDriver| For browser automation                              |
| Cucumber          | BDD framework for writing feature files             |
| JUnit             | Test runner                                          |
| Allure Reports    | Test reporting and visualization                    |
| Page Object Model | Design pattern for maintainable test structure      |


## ✅ Features Covered

- User login to OrangeHRM
- Navigating to the PIM tab and adding a new employee
- Navigating to the Admin tab and getting user count
- Adding, searching, and deleting admin users
- Verifying that user counts are correctly updated

---

## ⚙️ Setup Instructions

1. **Clone the repository**
   ```bash
     https://github.com/AzzaSalahEldin/OrangeHRM.git
# How to Run the Tests
mvn test
# Generate and View Allure Report
	allure generate allure-results --clean -o allure-report
        allure open allure-report
