package Jira;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class GetIssueDetails 
{
	@Test
	public void addAttachment()
	{
		RestAssured.baseURI="http://localhost:8080";
		SessionFilter session = new SessionFilter();
		given().log().all().header("Content-Type","application/json").body("{ \"username\": \"ismailzabi47\", \"password\": \"8749042573@Ji\"}").filter(session).when().post("rest/auth/1/session").
		then().log().all().assertThat().extract().response().asString();
		given().pathParam("key", "TES-5").queryParam("fields","comment").filter(session).log().all().when().get("/rest/api/2/issue/{key}").then().log().all().assertThat().statusCode(200).extract().response().asString();
	}

}
