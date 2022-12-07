package Jira;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class AttachingtheFile
{
	@Test
	public void addAttachment()
	{
		RestAssured.baseURI="http://localhost:8080";
		SessionFilter session = new SessionFilter();
		given().log().all().header("Content-Type","application/json").body("{ \"username\": \"ismailzabi47\", \"password\": \"8749042573@Ji\"}").filter(session).when().post("rest/auth/1/session").
		then().log().all().assertThat().extract().response().asString();
		given().pathParam("key", "TES-5").filter(session).log().all().header("X-Atlassian-Token","no-check").multiPart("file", new File("Test.txt")).when().post("/rest/api/2/issue/{key}/attachments").
		then().log().all().assertThat().statusCode(200);
	}
}