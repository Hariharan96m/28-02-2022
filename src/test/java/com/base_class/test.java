package com.base_class;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test extends Base_Class1 {
	@Test(priority = 1)
	private static void tc() {
		requestobject("https://reqres.in/");
		addHeader("Content-Type", "application/json");
		addqueryparameter("page", "2");
		responseObject("GET", "/api/users");
		printResponseBody();
		int statuscode = getStatusCode();
		Assert.assertEquals(statuscode, 200);
		System.out.println("GET Request is successful");
	}

	@Test(priority = 2)
	private static void tc1() {
		requestobject("https://reqres.in/");
		addHeader("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Hari");
		jsonObject.put("job", "QA");
		requestSpecification.body(jsonObject.toJSONString());
		responseObject("POST", "/api/users");
		int statusCode = getStatusCode();
		System.out.println(statusCode);
	}

	@Test
	private static void tc2() {

	}

	@Test
	private static void tc3() {
	}
}
