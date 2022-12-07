package Jira;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class AddCommentWithSession
{
	@Test
	public void AddComment()
	{
		RestAssured.baseURI="http://localhost:8080";
		SessionFilter session = new SessionFilter();
		String Comment="New comment added from eclipse with session";
		given().log().all().header("Content-Type","application/json").body("{ \"username\": \"ismailzabi47\", \"password\": \"8749042573@Ji\"}").filter(session).when().post("rest/auth/1/session").
		then().log().all().assertThat().extract().response().asString();
		given().pathParam("Key", "TES-5").log().all().header("Content-Type","application/json").body(JiraBody.AddingComment(Comment)).filter(session).
		when().post("/rest/api/2/issue/{Key}/comment").then().log().all().assertThat().statusCode(201);
	}
}
