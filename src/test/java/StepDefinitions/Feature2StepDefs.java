package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mappingclasses.employees_v1.employee_response.Employee;
import mappingclasses.employees_v1.employee_response.Employees;
import mappingclasses.employees_v1.employee_response.EmployeeGenericResponse;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class Feature2StepDefs {
    Response response;
    Employees allEmployees;
    Employee employee;

//    @Given("I access the employees api")
//    public void iAccessTheEmployeesApi() {
//        response = given().get("http://localhost:8144/api/restassured/employees");
//        System.out.println(response.getBody().asString());
//    }
//
//    //    @Given("I access the employees api")
//    public void iAccessTheEmployeesApia() {
//
//    }
//
//    @When("I Serialize the response with Employee class")
//    public void iSerializeTheResponseWithEmployeeClass() {
//        employee = response.as(Employee.class);
//    }
//
//    @Then("I should be able to view all the Employees")
//    public void iShouldBeAbleToViewAllTheEmployees() {
//        for(Employee employee: allEmployees.getEmployees()){
//            System.out.println(employee.getId());
//        }
//    }

//    @When("I Serialize the response with Employees class")
//    public void iSerializeTheResponseWithEmployeesClass() {
//        allEmployees = response.as(Employees.class);
//    }

//    @Given("I access the employee api with id {int}")
//    public void iAccessTheEmployeeApiWithId(int arg0) {
//        response = given().get("http://localhost:8144/api/restassured/employee/3");
//    }

//    @Then("I should be able to view all the information regarding employee")
//    public void iShouldBeAbleToViewAllTheInformationRegardingEmployee() {
//        System.out.println(employee.getId());
//        System.out.println(employee.getEmployee_name());
//        System.out.println(employee.getEmployee_salary());
//        System.out.println(employee.getEmployee_age());
//    }

    @Given("I create employee object")
    public void iCreateEmployeeObject() {
        employee = new Employee("17", "John", "32000", "28");
    }

    @When("I add a new employee")
    public void iAddANewEmployee() {
        response = given().contentType("application/json")
                .accept(ContentType.JSON)
                .body(employee)
                .when()
                .post("http://localhost:8144/api/restassured/addEmployee");
    }

    @Then("new employee should be added successfully")
    public void newEmployeeShouldBeAddedSuccessfully() {
        EmployeeGenericResponse employeeGenericResponse = response.as(EmployeeGenericResponse.class);
        Assert.assertEquals(employeeGenericResponse.getMessage(), "Employee with " + employee.getId() + " added successfully");
    }

    @Then("the response time should not exceed {int} seconds")
    public void theReponseTimeShouldNotExceedSeconds(int seconds) {
        response.then().time(lessThan((long)seconds), TimeUnit.SECONDS);
    }
}
