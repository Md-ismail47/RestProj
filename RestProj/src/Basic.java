import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basic 
{
	public static void main(String[] args)
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/maps/api/place/add/json";
		String respose=given().log().all().queryParam("Key", "qaclick123").header("content-Type","application/json")
		.body(Testclass.Body()).when().post()
		.then().log().all().statusCode(200).body("scope",equalTo("APP")).header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		System.out.println(respose);
		JsonPath js=new JsonPath(respose);
		String js1=js.getString("place_id");
		System.out.println(js1);
	}
}