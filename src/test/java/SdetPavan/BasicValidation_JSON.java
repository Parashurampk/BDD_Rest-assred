package SdetPavan;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/*
 * Test Status code  //.statusCode(200)
 * 
 * Log Response		//.log().all();
 * 
 * Verifying Single Content in response body //.body("response.id[0]",equalTo(1)) 
 * 
 * Verifying Multiple Content in response body //.body("response.id",hasItems(1,2,3,4,5,6,7,8,9,10));
 * 
 * Setting parameters and headers
    		given()
				.param("MyName","Parashuram")
				.header("MyHeader","Indian")
 * 
 */

public class BasicValidation_JSON {

	//@Test
	public void testStatusCode() {
		
		given()
		.when()
			.get("https://secure.drivezy.com/property?limit=250")
		.then()
			.statusCode(200)
			.log().all();
									
//		given().when().get("https://secure.drivezy.com/property?limit=250").then().statusCode(200).log().all();
	}
	
	@Test
	public void testSingleContent() {
		
		given()
		.when()
			.get("https://secure.drivezy.com/property?limit=250")
		.then()
			.statusCode(200)
			
			//Verifying Single Content in response body
			.body("response.id[0]",equalTo(1))  
			
			 //Verifying Multiple Content in response body
			.body("response.id",hasItems(1,2,3,4,5,6,7,8,9,10));
		
	}
	
		@Test
		public void testParametersAndHeaders() {
			
			given()
				.param("MyName","Parashuram")
				.header("MyHeader","Indian")
			.when()
				.get("https://secure.drivezy.com/property?limit=250")
			.then()
				.statusCode(200)
				.log().all();
		}
}
