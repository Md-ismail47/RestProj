package pojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GoogleMapsmain
{
	public static void main(String[] args)
	{
		mapsdata mp=new mapsdata();
		mp.setAccuracy(50);
		mp.setAddress("29, side layout, cohen 09");
		mp.setLanguage("English");
		mp.setName("Rest Assured");
		mp.setPhone_number("123456789");
		mp.setWebsite("https://google.com");
		List<String> types=new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		mp.setTypes(types);
		location lc=new location();
		lc.setLat(-38.383494);
		lc.setLng(33.427362);
		mp.setLocation(lc);
		RestAssured.baseURI="https://rahulshettyacademy.com/maps/api/place/add/json";
		String respose=given().log().all().queryParam("Key", "qaclick123").header("content-Type","application/json")
		.body(mp).when().post()
		.then().log().all().statusCode(200).body("scope",equalTo("APP")).header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		System.out.println(respose);
		JsonPath js=new JsonPath(respose);
		String js1=js.getString("place_id");
		System.out.println(js1);
	}

}
