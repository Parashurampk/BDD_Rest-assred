package SdetPavan;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class POSTMethodTest {
	
	public static HashMap map=new HashMap();
	
	@BeforeClass
	public void postData() {
		
		map.put("name", "tesgtd");
		map.put("salary", "1552355");
		map.put("age", "32");
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/";
		RestAssured.basePath="create";
	}
	
	@Test
	public void testPostrequest() {
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(200)
			.log().all()
			.body("status", equalTo("success"))
			.body("message", equalTo("Successfully! Record has been added."));
			
	}
}
