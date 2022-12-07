package Jira;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class AddingaComment 
{
	@Test
	public void AddComment()
	{
		String Sessionid=GetSession.GetSesssion();
		System.out.println(Sessionid);
		String comment="Test comment added from Eclipse";
		RestAssured.baseURI="http://localhost:8080";
		given().pathParam("Key", "TES-5").log().all().header("cookie","JSESSIONID="+Sessionid+"").header("Content-Type","application/json").body(JiraBody.AddingComment(comment)).
		when().post("/rest/api/2/issue/{Key}/comment").then().log().all().assertThat().statusCode(201);
	}
}