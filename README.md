# Java_Selenium_Automation_Framework_SW

## Features of the Framework:
-----------------------------
  * Cross Broswer Testing
  * configurations using properties files
      - baseURL
      - Waits
      - default browser and etc..
  * Screenshots for failed test cases
  * Running tests using maven profiles
  * DataDriven testing using Excel and apache POI library
  * dependency management and build tool : Maven 
  * Logging : log4j2
  * Reporting : extentreports


## Running the Tests : 
----------------------
  1. Clone this git repository
  1. Add the necessary drivers(Chromedriver, Geckodriver, edgedriver…) to this folder location:
     src/test/resources/drivers
  1. Change the baseurl path in env-qa.properties in this folder path:
     src/test/resources/configurations/env-qa.properties  
    (ex: baseurl = https://github.com/ )
  1. Import this as a maven project in any IDE 
  1. To run all the tests included in FunctionalTests profile :
      ```console
      mvn test -PFunctionalTests
      ```

    
