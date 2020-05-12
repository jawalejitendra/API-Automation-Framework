package mappingclasses.employees_v1.employee_requests;

import framework.interfaces.APIRequest;

public class Employee implements APIRequest {

    private String id;
    private String employee_name;
    private String employee_salary;
    private String employee_age;

    public Employee() {

    }

    public Employee(String id, String employee_name, String employee_salary, String employee_age) {
        this.id = id;
        this.employee_age = employee_age;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }

}
