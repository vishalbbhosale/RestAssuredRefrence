package vishal;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Rest_Get_Reference {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		
		//declare the given,when and then method 
		given().header("Content-Type","application/json").
			 when().get("api/users?page=2").then().log().all().extract().response();
			   
	}

}
