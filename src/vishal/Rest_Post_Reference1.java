package vishal;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.time.LocalDateTime;
import org.testng.Assert;
import io.restassured.path.json.JsonPath;

public class Rest_Post_Reference1 {
	public static void main(String[] args) {
//declare base URL
	  RestAssured.baseURI="https://reqres.in/";        
	  
//Declare request body
	  String requestBody="{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}";
	  
//declare the expected result
	  JsonPath JspRequest = new JsonPath(requestBody);
	  String Req_name=JspRequest.getString("name");
	  String Req_job=JspRequest.getString("job");
	  LocalDateTime currentdate = LocalDateTime.now();
	  String expecteddate=currentdate.toString().substring(0,11);  
	   
//declare the given,when and then method
      /*String responseBody=given().header("Content-Type","application/json").body(requestBody).log().all().when().post("api/users").then().log().all().extract().response().asString();
      System.out.println(responseBody);*/
      String responseBody=given().header("Content-Type","application/json").body(requestBody).
      when().post("api/users").then().extract().response().asString();
      System.out.println(responseBody);
    
 //create in object of JSON path to parse the ResponseBody
      JsonPath JspResponse = new JsonPath(responseBody);
      String Res_name=JspResponse.getString("name");
      String Res_job=JspResponse.getString("job");
      String Res_createdAt = JspResponse.getString("createdAt");
      Res_createdAt=Res_createdAt.substring(0,11);
   
 //validate the responsebody parameters
      Assert.assertEquals(Res_name,Req_name);
      Assert.assertEquals(Res_job, Req_job);
      Assert.assertEquals(Res_createdAt, expecteddate);
   
   
 
   
   
   
   
   
   
   
   
   
	}

}
