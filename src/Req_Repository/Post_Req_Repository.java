package Req_Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Api_Method.Common_Utility_Method;
import Common_Api_Method.Common_Utility_Method;

public class Post_Req_Repository {
	
	public static String baseURI() {
		String baseURI="https://reqres.in/";
		return baseURI;
	}
   public static String Post_Resourse() {
	   String Post_Resourse="api/users";
	   return Post_Resourse;
   }
   
   public static String Post_TC1() throws IOException {
	   ArrayList<String> Req_Data= Common_Utility_Method.ReadDataExcel("PostApi", "TC2");
	   //System.out.println(Req_Data);
		String Req_name=Req_Data.get(0);
    	String Req_job=Req_Data.get(1);
    	
    	
	   String Requestbody="{\r\n"
	   		+ "    \"name\": \""+Req_name+"\",\r\n"
	   		+ "    \"job\": \""+Req_job+"\"\r\n"
	   		+ "}";
	   return Requestbody;
   }
}
