package vishal;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import io.restassured.path.xml.*;

public class soup_api_reference {

	public static void main(String[] args) {
		RestAssured.baseURI="https://www.dataaccess.com/";
		//declare request body
		String RequestBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>22.22</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>\r\n";
		
		
		//extract responsebody
		String ResponseBody=given().header("Content-Type","text/xml; charset=utf-8").body(RequestBody).log().all().
				when().post("webservicesserver/NumberConversion.wso?wsdl").then().log().all().extract().response().asString();
	System.out.println(ResponseBody);
		
		//parse the response body
		XmlPath XmlResponse=new XmlPath(ResponseBody);
		String Responseparameter=XmlResponse.getString("NumberToWordsResult");
	System.out.println(Responseparameter);
	
	//validate responsebody parameter
	Assert.assertEquals(Responseparameter, "twenty two ");
	
	
		
		
		

	}

}
