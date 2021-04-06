package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class PutPatchandDeleteExamples {
	
	@Test
	public void testPut() {
		
		baseURI="https://reqres.in/api";
		JSONObject request=new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		 given()
		.body(request.toJSONString())
		.when()
		.put("/users/2")
		.then()
		.statusCode(200)
		.log().all();
	
		
	}
	
	@Test
	public void testPatch() {
		
		baseURI="https://reqres.in/api";
		JSONObject request=new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		 given()
		.body(request.toJSONString())
		.when()
		.patch("/users/2")
		.then()
		.statusCode(200)
		.log().all();
	
		
	}
	
	@Test
	public void testDelete() {
		baseURI="https://reqres.in/api";
		when()
		.delete("/users/2")
		.then()
		.statusCode(204);
	}

}
