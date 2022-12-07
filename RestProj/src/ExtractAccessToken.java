import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ExtractAccessToken 

{
	
	public static String AccessToken()
	{
		String username="devbox435@test.co";
		String password="Qwerty@123";
		String granttype="password";
		String clientSecret="D6996A5F20AB488DF0E382B95EB9A42D30BED50E5F836D228ECDC5677B4D8C4F";
		String clientId="3MVG9fe4g9fhX0E5_WrFL9oA6pLgiCeEJAnieXyDxy1NoTF68DtiJyMEKRuFYtgf_Zo0ySKt3ZfEEQrd2QbVI";
		RestAssured.baseURI="https://testco-3b-dev-ed.my.salesforce.com/services/oauth2/token";
		String Response = given().log().all().queryParam("username",username).queryParam("password", password).queryParam("grant_type",granttype)
		.queryParam("client_id", clientId).queryParam("client_secret",clientSecret).
		when().post().then().log().all().extract().response().asString();
		System.out.println("Respose recieved---->"+Response);
		JsonPath js=new JsonPath(Response);
		String Access = js.getString("access_token");
		System.out.println(Access);
		return Access;
	}
}