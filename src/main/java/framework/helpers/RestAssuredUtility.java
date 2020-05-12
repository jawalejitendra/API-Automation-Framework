package framework.helpers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtility {
    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;

    public RestAssuredUtility(String url, String method) {
        this.method = method;
        this.url = url;
    }

    private ResponseOptions<Response> executeAPI() {
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(builder.build());
        if (this.method.equalsIgnoreCase("POST")) {
            return request.post(this.url);
        } else if (this.method.equalsIgnoreCase("DELETE")) {
            return request.delete(this.url);
        } else if (this.method.equalsIgnoreCase("GET")) {
            return request.get(this.url);
        }
        return null;
    }

    public ResponseOptions<Response> executeGetMethod () {
        return executeAPI();
    }


}
