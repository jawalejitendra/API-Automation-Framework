Feature: Serialization and Deserialization of objects

  @employee-tc01
  Scenario: Get all employees and using Deserialization of employees
    Given I access the employees api
    When I Serialize the response with Employees class
    Then I should be able to view all the Employees

  @employee-tc02
  Scenario: Get the employee and using Deserialization of employee
    Given I access the employee api with id 3
    When I Serialize the response with Employee class
    Then I should be able to view all the information regarding employee

  # Remove the employee with id 17 the scenario fails
  @employee-tc03
  Scenario: Add a new employee using Serialization of employee object
    Given I create employee object
    When I add a new employee
    Then new employee should be added successfully

  @employee-tc04
  Scenario: Get the response time of GET all employees
    Given I access the employees api
    Then the response time should not exceed 5 seconds

  Scenario: Get all employees and using Deserialization of employees using utility
    Given I access the employees api using utility
    When I Serialize the response with Employees class using utility
    Then I should be able to view all the Employees using utility