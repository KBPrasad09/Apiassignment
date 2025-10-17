Agify API BDD Testing Suite
A simple Behavior-Driven Development (BDD) test suite for the agify.io API using Cucumber, REST Assured, and Java.
Overview
The agify.io API predicts a person's age based on their name. This project contains automated BDD tests to validate the API functionality.
API Endpoint: https://api.agify.io/?name={name}
Example Request:
GET https://api.agify.io/?name=john
Example Response:
json{
  "name": "john",
  "age": 59,
  "count": 12345
}

Prerequisites

Java: 11 or higher
Maven: 3.6 or higher
Internet Connection: Required to call the agify.io API

Verify Installation
bashjava -version
mvn --version

Installation & Setup
1. Clone the Repository
bashgit clone https://github.com/KBPrasad09/Apiassignment.git
cd Apiassignment
2. Install Dependencies
bashmvn clean install
This will download all required dependencies:

Cucumber 7.14.0
REST Assured 5.3.2
Gson 2.10.1
JUnit 4.13.2

Test Scenarios
Feature File: agify.feature
The test suite includes 4 scenarios (2 positive, 2 negative):

Scenario 1: Valid name returns age
gherkinWhen I request age for name "john"
Then status code is 200
And response has age field

Tests that a valid name returns a successful response
Validates that the response contains an age field

Scenario 2: Another valid name works
gherkinWhen I request age for name "anna"
Then status code is 200
And age is between 1 and 120

Tests that different valid names work correctly
Validates that returned age is within realistic range (1-120)

Scenario 3: Empty name request
gherkinWhen I request age for name ""
Then status code is 200
And response has age field

Tests API behavior with empty name parameter
API still returns a response (not an error)

Scenario 4: Special characters in name
gherkinWhen I request age for name "@#$"
Then status code is 200
And response has age field

Tests API behavior with special characters
Validates that API handles invalid input gracefully


Technologies Used
TechnologyVersionPurposeJava11+Programming languageCucumber7.14.0BDD frameworkREST Assured5.3.2API testing libraryGson2.10.1JSON parsingJUnit4.13.2Assertion frameworkMaven3.6+Build automation tool


Dependencies (pom.xml)
xml<dependencies>
    <!-- Cucumber -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.14.0</version>
    </dependency>
    
    <!-- REST Assured -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.2</version>
    </dependency>
    
    <!-- Gson -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
    
    <!-- JUnit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
    </dependency>
</dependencies>

License
This project is open source and available under the MIT License.

Author
QA Engineer
Testing the agify.io API with BDD approach

Contact & Support

API Documentation: https://agify.io/documentation
REST Assured Documentation: https://rest-assured.io/
Cucumber Documentation: https://cucumber.io/


Version History
VersionDateChanges1.02024Initial release with 4 BDD scenarios
