package mappingclasses.employees_v1.employee_response;

import framework.interfaces.APIResponse;
import io.restassured.response.Response;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Employees implements APIResponse {

    private final static String SCHEMA_FILENAME = "employees-schema.json";
    String name;
    List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equalsTo() {
        return false;
    }

    @Override
    public String getSchemaFileName() {
       return SCHEMA_FILENAME;
    }
}
