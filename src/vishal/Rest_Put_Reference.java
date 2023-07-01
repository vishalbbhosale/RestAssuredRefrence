package vishal;

import static io.restassured.RestAssured.given;
import java.time.LocalDateTime;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Rest_Put_Reference {
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		
		//declare base url
		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		
		//declare the expected result
		JsonPath JspRequest = new JsonPath(requestBody);
		 String Req_name=JspRequest.getString("name");
		   String Req_job=JspRequest.getString("job");
		 LocalDateTime currentdate = LocalDateTime.now();
		   String expecteddate=currentdate.toString().substring(0,11);
		   
		   //declare the given,when and then method   
         String responseBody=given().header("Content-Type","application/json").body(requestBody).log().all().
	       when().put("api/users/2").then().log().all().extract().response().asString();
	    System.out.println(responseBody);
	    
	    //create in object of JSON path to parse the ResponseBody
	   JsonPath JspResponse = new JsonPath(responseBody);
	   String Res_name=JspResponse.getString("name");
	   String Res_job=JspResponse.getString("job");
	   String Res_updatedAt = JspResponse.getString("updatedAt");
	   Res_updatedAt=Res_updatedAt.substring(0,11);
	   
	   //validate the responsebody parameters
	   Assert.assertEquals(Res_name,Req_name);
	   Assert.assertEquals(Res_job, Req_job);
	   Assert.assertEquals(Res_updatedAt, expecteddate);
	   
		
		

	}

}
