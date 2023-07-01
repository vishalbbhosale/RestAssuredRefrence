package vishal;

import java.time.LocalDateTime;

import org.testng.Assert;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Rest_patch_Reference {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
				
	//declare base url
	String RequestBody="{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"zion resident\"\r\n"
			+ "}";
		
//declare expected result
	JsonPath JspRequest = new JsonPath(RequestBody);
	String 	Req_name= JspRequest.getString("name");
	String Req_job= JspRequest.getString("job");
	LocalDateTime currentdate = LocalDateTime.now();
	String expecteddate = currentdate.toString().substring(0,11);
	
	//declare given , when and then method
	String responsebody=given().header("Content-Type","application/json").body(RequestBody).log().all().
			when().patch("api/users/2").then().log().all().extract().response().asString();
	System.out.println(responsebody);
	
	//create on object in JSON path to parse the responsebody
	JsonPath JspResponse = new JsonPath(responsebody);
	String Res_name= JspResponse.getString("name");
	String Res_job= JspResponse.getString("job");
	String Res_updatedAt =JspResponse.getString("updatedAt");
	Res_updatedAt=Res_updatedAt.substring(0,11);
	
	//validate responsebody parameters
	Assert.assertEquals(Res_name, Req_name);
	Assert.assertEquals(Res_job, Req_job);
	Assert.assertEquals(Res_updatedAt, expecteddate);
	
	
	
	
	
	
	
	}

}
