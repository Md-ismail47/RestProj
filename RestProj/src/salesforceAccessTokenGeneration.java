import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
public class salesforceAccessTokenGeneration
{
	public static void main(String[] args)
	{
		RestAssured.baseURI="https://testco-3b-dev-ed.my.salesforce.com/services/oauth2/token";
		given().log().all().queryParam("username", "devbox435@test.co").queryParam("password", "Qwerty@123").queryParam("grant_type", "password")
		.queryParam("client_id", "3MVG9fe4g9fhX0E5_WrFL9oA6pLgiCeEJAnieXyDxy1NoTF68DtiJyMEKRuFYtgf_Zo0ySKt3ZfEEQrd2QbVI").
		queryParam("client_secret", "D6996A5F20AB488DF0E382B95EB9A42D30BED50E5F836D228ECDC5677B4D8C4F").when().post().then().log().all();
	}
}