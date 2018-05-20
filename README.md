# instafin_test

### Objective: ### 
Design framewirk for automating non-angular, React based web-app

 ### Tech Stack: ### 
* Java 8
* Selenium WebDriver
* TestNG
* Cucumber
* Gradle 4.3.1
* geckodriver
* Firefox exe
* git
* GitLab CI

 ### System Requirements to run the tests: ### 
* Windows
* Java 8
* Gradle 4.3.1
* Firefox.exe

For Linux/Ubuntu plain docker, take code from repo - https://gitlab.com/ShilpiBansal/instafin_test

 ### Architechture: ### 
The framework is using Page Object Model, that is used to segregate page dependent information from test logic. For each pages there should be one pageObject, listing all elements locators and the methods on those elements.


There are two modules under testModule:


#### Under functional module:
* Page objects are grouped at /src/main/java/org/page/objects
* The functional tests on these pages are grouped at /src/test/java/functional
* Step definitions for Cucumber steps are at /src/test/java/stepDefinitions
* test data for test cases is at /src/test/resources
* And Cucumber feature file is at /src/test/resources/features
* TestNG suite file

#### Under TestCore module,
* we have utils, or say helpers, for our test cases, at /src/main/java/utils
* And test environment configs at /src/main/resources 
* All external methods are wrapped under utils method to save rework due to deprecated methods in upgraded versions. 

* Each module has its own build.gradle file. The test tasks are created in build file functionalTests module.
* There is also geckodriver, to execute the test cases on browser, at root level

 ### Test Scenarios: ### 
For demo, two scenarios are automated, one using TestNG and other Cucumber.
#### TestNG scenario:
* Use case
    * user should be able to login and create a new individual client with valid mandatory data, and verify that created client's status is 'Pending Approval'
    * the test case has no dependency on any other test case, ID entered is also unique everytime. Though unable to clean environment after test as there is no way (without server access) to do the same.
* Execution
  * To run the test case there are three options,
      * Right clik on test file from IDE and run as TestNG (requires TestNG plugin)
      * Run the suite xml file
      * Run via Gradle task, from root directory run the following commands
        * gradle clean build
        * gradle clean testNGTests
* Test Result
  * An HTML report will be generated, example at 'testModule/functionalTests/build/reports/tests/testNGTests/index.html'
  * Screenshot for failing tests will be taken, example at 'testModule/functionalTests/verifyIndividualAcountCreation(functional.IndividualClientCreation)-20180519-052430-screenshot.png'
			
#### Cucumber Scenario:
* Use case
  * a logged in user goes to All Transaction Reports page, filters transactions and export its excel. The file should be downloaded and should have expected number of transactions.
  * test needs the test data as per the feature file. As part of cleaning, the downloaded file is deleted after verification.
* Execution
  * To run the test case, there are two options
    * Right click on file in IDE and run as Cucumber feature (requires plugin)
    * Run via Gradle task, from root directory run the following commands
      * gradle clean build
      * gradle clean runCucumberScenario
 					
 ### For CI,  ### 
 gitLab CI is used, please refer 'https://gitlab.com/ShilpiBansal/instafin_test'
* Here the tests are running on an Ubuntu docker image in headless mode.
* There are two test jobs, 
* testNG_test - for testNG test, the result report can be downloaded from artifacts
* cucumber_test - for cucumber test
					
