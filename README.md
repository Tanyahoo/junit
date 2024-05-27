# **Agile Software Development JUnit Testing - 2023**

## Introduction 

This repository contains the solution for an assignment of the Agile Software Development module at Atlantic Technological University, Galway as part of the Higher Diploma in Software Development. The assignment aims to develop a JUnit automated test suite for testing the provided Java application, InsuranceProgram.java. 

This is a fictitious scenario whereby a car insurance company's java application generates a premium, dependent on the assessment of user input, respresentative of a potential customers' age and car accident history. As part of the project, the given code within InsuranceProgram.java is refactored to allow for meaningful tests to be carried out on the application. 

### Project Structure and Classes 

- InsuranceProgramRefactored.java:
  
  Refactored version of the original InsuranceProgram.java which calculates the insurance premium based on the customer’s age and number 
  of previous car accidents. 

- Runner.java:
  
  Contains the main method which is the entry point into the application. 

- InsuranceProgramRefactoredTest.java:
  
  Contains the JUnit tests for InsuranceProgramRefactored.java. 

- RunnerTest.java:
  
  Additional class containing JUnit tests. 

### JUnit Annotations and Assertions 

JUnit provides a range of annotations and assertions for testing: 

**Annotations:** 

@BeforeAll 

@BeforeEach 

@AfterAll 

@AfterEach 

@Test 

@ParameterizedTest 

@Timeout 

@Disabled 

**Assertions:** 

assertEquals 

assertTrue 

assertThrows 



Additionally, the test code handles two distinct kinds of exceptions encountered during testing: 

- ArithmeticException 

- IllegalArgumentException 

### Getting Started 

**Prerequisites** 

- Java Development Kit (JDK): Ensure you have JDK 17 or later installed. 

- JUnit 5: The project uses JUnit 5 for testing. 

### Installation 

1.Clone the Repository: 

	git clone https://github.com/Tanyahoo/junit.git 
 

2. Navigate to the Project Directory: 

	cd junit 
 

### Usage 

**Run Application** 

1. The refactored code can be called via Runner.java which contains the main method, calling an instance of InsuranceProgramRefactored.java and thus beginning the application. 

2. User input is solicited as a potential car insurance ‘customer’ and outputs results which are printed to the console. 

### Run Tests 

 Execute each of the JUnit test classes; within the Eclipse IDE this can be done by selecting ‘Run As JUnit Test’. 
Comprehensive tests are written in the both classes: 
- InsuranceProgramRefactoredTest.java and 
- RunnerTest.java. 

- Both classes are called and tested within AssignmentSuiteTest.java.

 ### Result

Coverage of tests is verified by color indicators within the IDE (Eclipse in my case), 
- showing either red (failed) or
- green (passed). 

Each method is tested using the JUnit annotations outlined above and the code is comprehensively commented throughout.

**Note**

This repository serves as a demonstration of my solution for a fictional scenario and is intended for educational purposes only. 

 
 

 
