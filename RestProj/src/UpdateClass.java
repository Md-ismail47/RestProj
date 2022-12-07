import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UpdateClass {

	public static void main(String[] args)
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String respose=given().log().all().queryParam("Key", "qaclick123").header("content-Type","application/json")
		.body(Testclass.Body()).when().post("maps/api/place/add/json")
		.then().log().all().statusCode(200).body("scope",equalTo("APP")).header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		System.out.println(respose);
		JsonPath js=new JsonPath(respose);
		String js1=js.getString("place_id");
		System.out.println(js1);
		
		given().log().all().queryParam("Key", "qaclick123").header("content-Type","application/json").body("{\r\n"
				+ "\"address\": \"Basavanagudi,bangalore\",\r\n"
				+ "\"place_id\": \""+js1+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").
		when().put("maps/api/place/update/json").		
		then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	}
}
