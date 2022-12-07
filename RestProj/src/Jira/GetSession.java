package Jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetSession 
{
	
	public static String GetSesssion()
	{
		RestAssured.baseURI="http://localhost:8080";
		String Response = given().log().all().header("Content-Type","application/json").body("{ \"username\": \"ismailzabi47\", \"password\": \"8749042573@Ji\"}").when().post("rest/auth/1/session").
		then().log().all().assertThat().extract().response().asString();
		JsonPath js=new JsonPath(Response);
		String Sessionid = js.getString("session.value");
		return Sessionid;
	}

}
