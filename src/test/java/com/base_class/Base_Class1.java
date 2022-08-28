package com.base_class;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base_Class1 {
	public static RequestSpecification requestSpecification;
	public static Response response;

	// RequestObject
	public static void requestobject(String baseURI) {
		RestAssured.baseURI = baseURI;
		requestSpecification = RestAssured.given();
	}

	// header
	public static void addHeader(String headerName, String headervalue) {
		RequestSpecification header = requestSpecification.header(headerName, headervalue);

	}

	// Query Parameter
	public static void addqueryparameter(String parameterName, String parameterValues) {
		requestSpecification.queryParam(parameterName, parameterValues);
	}

	// path parameter
	public static void addPathParameter(String parameterName, String parameterValues) {
		RequestSpecification pathParam = requestSpecification.pathParam(parameterName, parameterValues);

	}

	// Response Object
	public static void responseObject(String requestType, String resources) {
		switch (requestType) {
		case "GET":
			response = requestSpecification.request(Method.GET, resources);
		case "PUT":
			response = requestSpecification.request(Method.PUT, resources);
		case "DELETE":
			response = requestSpecification.request(Method.DELETE, resources);
		default:
			response = requestSpecification.request(Method.POST, resources);
		}
	}

	public static void printResponseBody() {
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
	}

	public static int getStatusCode() {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
}
