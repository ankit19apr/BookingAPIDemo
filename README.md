# Automated Testing Framework with RestAssured and Cucumber

This repository contains an **automated testing framework** built using **Java**, **RestAssured**, **Cucumber**, and **Extent Reports**. The framework is designed to perform **API testing** for a sample booking system, ensuring proper functionality and robustness by testing both valid and invalid inputs.

---

## Features

- **Modular Structure**: Clearly organized folders for easy navigation and maintenance.
- **Cucumber BDD**: Implements Behavior-Driven Development using Cucumber for clear, understandable test scenarios.
- **RestAssured Integration**: Simplifies API testing and verification.
- **Extent Reports**: Detailed, visually appealing test execution reports with pass/fail statuses.
- **Negative Test Cases**: Robust validation with tests covering invalid inputs and edge cases.
- **Reusable Components**: Utility classes and POJOs streamline API request and response handling.

---

## Project Structure

src/ ├── main/ │ └── java/ │ ├── models/ # POJOs for API request/response bodies │ ├── utils/ # Utility classes for reusable code ├── test/ └── java/ ├── features/ # Cucumber feature files ├── stepdefinitions/ # Step definition files ├── runners/ # Test runner class ├── hooks/ # Hooks for setup/teardown └── reports/ # Extent report configuration


---

## Prerequisites

- **Java 8 or above**: Required to run the framework.
- **Maven**: For dependency management and building the project.
- **IntelliJ IDEA** or any Java IDE: To write and execute tests.
- **Git**: For version control.

---

## Dependencies

This project uses the following dependencies:

- **RestAssured**: For making API requests and performing assertions.
- **Cucumber**: To write tests in Behavior-Driven Development style.
- **JUnit**: For test execution.
- **Extent Reports**: To generate detailed, interactive test reports.
- **Gson**: For JSON serialization and deserialization.

---

## Setup and Execution

### **1. Clone the Repository**

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
2. Import the Project
Open IntelliJ IDEA (or your preferred IDE).
Import the project as a Maven project.
3. Install Dependencies
Ensure that Maven is properly configured.
Run the following command to install the required dependencies:
bash
Copy
Edit
mvn clean install
4. Run the Tests
Using the Test Runner:
Navigate to the src/test/java/runners/ directory.
Run the TestRunner.java class.
Using Maven Command:
bash
Copy
Edit
mvn test
5. View Test Reports
After test execution, the Extent Report will be generated and can be found here:

bash
Copy
Edit
target/reports/ExtentReport.html
Example Usage
Cucumber Feature File
Example feature file for booking API testing (src/test/resources/features/Booking.feature):

gherkin
Copy
Edit
Feature: Booking API Testing

  Scenario: Create and retrieve a booking
    Given the booking payload is created
    When the booking API is called to create a booking
    Then the created booking can be retrieved
Step Definition Example
java
Copy
Edit
@When("the booking API is called to create a booking")
public void the_booking_api_is_called_to_create_a_booking() {
    response = request.when().post("https://restful-booker.herokuapp.com/booking");
    response.prettyPrint(); // Prints the API response
    bookingId = response.jsonPath().getInt("bookingid");
}
Reporting
Extent Reports provide detailed reports, including:
Pass/Fail status for each step.
Request and response logs for better transparency.
Screenshots (if configured) for failed tests.
Contributing
Contributions are welcome! Please follow these steps:

Fork the repository.
Create a new branch for your feature (git checkout -b feature-name).
Commit your changes (git commit -m "Add feature").
Push to the branch (git push origin feature-name).
Open a pull request with a description of your changes.


Contact
For any questions or suggestions, feel free to reach out:

Name:Ankit Sharma
