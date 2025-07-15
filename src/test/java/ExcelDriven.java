import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class ExcelDriven {

	@Test
	public void Addbook()
	{
		HashMap<String, Object> jsonAsMap=new HashMap<>();
		jsonAsMap.put("name", "Learn Appium Automation with Java");
		jsonAsMap.put("isbn", "laawj");
		jsonAsMap.put("aisle", "712");
		jsonAsMap.put("author", "Alex");
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String resp=given().header("Content-Type","application/json")
		/*		.body("{\r\n"
				+ "    \"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "    \"isbn\":\"abccddeff\",\r\n"
				+ "    \"aisle\":\"247\",\r\n"
				+ "    \"author\":\"Keerthana\"\r\n"
				+ "}")    	*/
				.body(jsonAsMap)
				.when().post("/Library/Addbook.php")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON)
				.extract().response().asString();
		JsonPath js= new JsonPath(resp);
		String id=js.get("ID");
		System.out.println(id);
		
	}
}
