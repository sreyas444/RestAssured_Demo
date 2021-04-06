package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetandPostExamples {
	
	
	@Test
	public void testGet() {
		
		baseURI="https://reqres.in/api";
		given()
		  .get("/users?page=2")
		  .then()
		  .statusCode(200)
		  .body("data[4].first_name",equalTo("George"));

		
	}
	
	@Test
	public void testPost() {
		
		/*
		 * Map<String, Object> map=new HashMap<String, Object>(); map.put("name",
		 * "Sreyas"); map.put("job", "Automation Test Engineer");
		 * System.out.println(map);
		 */
		
		JSONObject request=new JSONObject();
		request.put("Name", "Sreyas");
		request.put("Job", "Test Engineer");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		given()
		
		
		.accept(ContentType.XML)
		.body(request.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201).log().all();
	}

}
