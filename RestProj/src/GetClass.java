import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetClass {

	public static void main(String[] args)
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String respose=given().log().all().queryParam("Key", "qaclick123").header("content-Type","application/json")
		.body(Testclass.Body()).when().post("maps/api/place/add/json")
		.then().log().all().statusCode(200).body("scope",equalTo("APP")).header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		System.out.println(respose);
		JsonPath js=new JsonPath(respose);
		String placeid=js.getString("place_id");
		System.out.println("Debug1 --"+placeid);
		String Address="Basavanagudi,bangalore";
		
		given().log().all().queryParam("key", "qaclick123").header("content-Type","application/json").body("{\r\n"
				+ "\"address\":\""+Address+"\",\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").
		when().put("maps/api/place/update/json").		
		then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		System.out.println("--------------");
		
		String getResponse1=given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeid).
		when().get("maps/api/place/get/json").
		then().log().all().extract().response().asString();
		System.err.println("===========================");
		System.out.println(getResponse1);
		JsonPath addJson = new JsonPath(getResponse1);
		String add = addJson.getString("address");
		System.out.println(add);
		Assert.assertEquals(Address, add);
	}
	
	

}
