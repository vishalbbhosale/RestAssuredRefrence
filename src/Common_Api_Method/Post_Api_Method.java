package Common_Api_Method;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Post_Api_Method {
	
	public static int responsestatuscode(String baseURI,String Post_Resourse,String Requestbody) {
		RestAssured.baseURI=baseURI;
		
		int statuscode= given().header("Content-Type","application/json").body(Requestbody).when().post("api/users").then().extract().statusCode();
	return statuscode;
	}
 
	public static String Responsebody(String baseURI,String Resourse,String Requestbody) {
		String Responsebody=given().header("Content-Type","application/json").body(Requestbody).when().post("api/users").then().extract().response().asPrettyString();
		return Responsebody;
	}
}
