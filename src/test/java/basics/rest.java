package basics;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class rest {
	@Test
	public void tc() {

		// create an object for Request
		RestAssured.baseURI = "https://reqres.in/";
		// to create request object
		RequestSpecification requestSpecification = RestAssured.given();
		// to specify the query parameter
		requestSpecification.queryParam("page", "2");
		// to create the response object
		Response response = requestSpecification.request(Method.GET, "/api/users");
		// to print the response body
		String asPrettyString = response.getBody().asPrettyString();
		System.out.println(asPrettyString);

	}

}
