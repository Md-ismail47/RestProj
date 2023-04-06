import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CreateAccountSalesforce
{
	public static void main(String[] args)
	{
		String AccessToken = ExtractAccessToken.AccessToken();
//		RestAssured.baseURI="https://testco-3b-dev-ed.my.salesforce.com";
//		String response = given().log().all().auth().oauth2(AccessToken).headers("Content-Type","application/json").body("{\r\n"
//				+ "  \"Name\" : \"Express Logistics and Transport\"\r\n"
//				+ "}").
//		when().post("/services/data/v56.0/sobjects/Account").then().log().all().extract().response().asString();	
//		JsonPath js=new JsonPath(response);
//		String id = js.getString("id");
//		System.out.println(id);
	}
}