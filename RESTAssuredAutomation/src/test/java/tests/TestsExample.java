package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class TestsExample {

	@Test(priority = 0)
	public void test_1() {
		
		Response response=get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		
		Assert.assertEquals(200, response.getStatusCode());
		
		
	}
	@Test(priority = 1)
	public void test_2() {
		
		System.out.println("Test2 ---- ");
		
		given()
		  .get("https://reqres.in/api/users?page=2")
		.then()
		  .statusCode(200)
		  .body("data[0].id", equalTo(7))
		  .log().all();
		
	}

}
