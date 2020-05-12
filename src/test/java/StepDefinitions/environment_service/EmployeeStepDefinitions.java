package StepDefinitions.environment_service;

import datacontexts.ResponseObject;
import framework.helpers.RestAssuredUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mappingclasses.employees_v1.employee_response.Employee;
import mappingclasses.employees_v1.employee_response.Employees;

import static io.restassured.RestAssured.given;

public class EmployeeStepDefinitions {
    private ResponseObject responseObject;
    RestAssuredUtility restAssuredUtility;
    Employee employee;
    Employees allEmployees;

    public EmployeeStepDefinitions(ResponseObject responseObject) {
        this.responseObject = responseObject;
    }

    @Given("I access the employees api")
    public void iAccessTheEmployeesApi() {
        restAssuredUtility = new RestAssuredUtility("http://localhost:8144/api/restassured/employees", "GET");
        responseObject.response = restAssuredUtility.executeGetMethod();
        System.out.println(responseObject.response.getBody().asString());
    }
    @When("I Serialize the response with Employees class")
    public void iSerializeTheResponseWithEmployeesClass() {
        allEmployees = responseObject.response.getBody().as(Employees.class);
    }

    @Then("I should be able to view all the Employees")
    public void iShouldBeAbleToViewAllTheEmployees() {
        for(Employee employee: allEmployees.getEmployees()){
            System.out.println(employee.getId());
        }
    }


    @Given("I access the employee api with id {int}")
    public void iAccessTheEmployeeApiWithId(int arg0) {
        restAssuredUtility = new RestAssuredUtility("http://localhost:8144/api/restassured/employee/3", "GET");
        responseObject.response = restAssuredUtility.executeGetMethod();
    }

    @When("I Serialize the response with Employee class")
    public void iSerializeTheResponseWithEmployeeClass() {
        employee = responseObject.response.getBody().as(Employee.class);
    }

    @Then("I should be able to view all the information regarding employee")
    public void iShouldBeAbleToViewAllTheInformationRegardingEmployee() {
        System.out.println(employee.getId());
        System.out.println(employee.getEmployee_name());
        System.out.println(employee.getEmployee_salary());
        System.out.println(employee.getEmployee_age());
    }

}
