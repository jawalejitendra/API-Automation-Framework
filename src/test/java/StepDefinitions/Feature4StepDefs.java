package StepDefinitions;

import datacontexts.ResponseObject;
import framework.helpers.RestAssuredUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import mappingclasses.employees_v1.employee_response.Employee;
import mappingclasses.employees_v1.employee_response.Employees;

public class Feature4StepDefs extends ResponseObject {
    ResponseObject responseObject;
    Employees allEmployees;

    RestAssuredUtility restAssuredUtility;

    Feature4StepDefs(ResponseObject responseObject) {
        this.responseObject = responseObject;
    }

    @Given("I access the employees api using utility")
    public void iAccessTheEmployeesApi() {
        restAssuredUtility = new RestAssuredUtility("http://localhost:8144/api/restassured/employees", "GET");
        response = restAssuredUtility.executeGetMethod();

//        response = given().get("http://localhost:8144/api/restassured/employees");
//        System.out.println(response.getBody().asString());
    }

    @When("I Serialize the response with Employees class using utility")
    public void iSerializeTheResponseWithEmployeesClass() {
        allEmployees = response.getBody().as(Employees.class);
    }

    @Then("I should be able to view all the Employees using utility")
    public void iShouldBeAbleToViewAllTheEmployees() {
        for (Employee employee : allEmployees.getEmployees()) {
            System.out.println(employee.getId());
        }
    }

}
