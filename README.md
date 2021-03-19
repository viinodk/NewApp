# NewApp
vinod app

This is an automation frmaework for a mobile app using Appium + Selenium + TestNG + Maven Framework.

#Documentation

### Prerequisite to build the repository
- [Download](http://java.com/en/download/index.jsp) Java Runtime Environment Once JRE is installed, set path to the java bin folder, so that you can execute java anywhere
- [Download](https://maven.apache.org/download.cgi) Install latest the Apache Maven Project, set path to the Maven bin folder, so that you can execute Maven anywhere
- [Download](https://github.com/viinodk/NewApp.git) main branch in git
- [Download](https://appium.io/) appium standalone
- [Download](https://mvnrepository.com/artifact/io.appium/java-client) java appium client binaries

### Build the project

CLI commands:

- Maven-built projects can be built with the following command:

    > `mvn clean install`
	
- Maven Phases
	1. validate: validate the project is correct and all necessary information is available
		> `mvn validate`
	2. compile: compile the source code of the project
		> `mvn compile`
	3. test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
		> `mvn test`	
	4. verify: run any checks to verify the package is valid and meets quality criteria
		> `mvn verify`
	5. install: install the package into the local repository, for use as a dependency in other projects locally
		> `mvn install`

Framework Overview:-

Suite defined in testng.xml triggers the java file which has TestNG methods, to execute the test script

Each test script is coupled into a DataProvider which has a HashMap to run through the columns and row of excel containing test data

Logs created from log4j.properties file
HTMl Reports created from Extent file
