package pojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.devtools.v85.applicationcache.ApplicationCache;

import groovy.lang.Buildable;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.http.URIBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class GoogleMapsmainSpec
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
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/maps/api/place/add/json").addQueryParam("Key", "qaclick123").setContentType(ContentType.JSON).build();
		RestAssured.baseURI="";
		String respose=given().log().all().spec(req)
		.body(mp).when().post()
		.then().log().all().statusCode(200).body("scope",equalTo("APP")).header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		System.out.println(respose);
		JsonPath js=new JsonPath(respose);
		String js1=js.getString("place_id");
		System.out.println(js1);
	}
}