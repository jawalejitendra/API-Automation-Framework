package mappingclasses.employees_v1.employee_response;

import framework.interfaces.APIResponse;

public class EmployeeGenericResponse implements APIResponse {
    private String message;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equalsTo() {
        return false;
    }

    @Override
    public String getSchemaFileName() {
        return null;
    }
}
