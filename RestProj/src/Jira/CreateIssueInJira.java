package Jira;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateIssueInJira 
{
	@Test
	public void CreateIssue()
	{
		
		String Sessionid=GetSession.GetSesssion();
		System.out.println(Sessionid);
		RestAssured.baseURI="http://localhost:8080";
		String Response = given().log().all().header("cookie","JSESSIONID="+Sessionid+"").header("Content-Type","application/json").body(JiraBody.creteJiraIssueBody()).
		when().post("rest/api/2/issue").then().log().all().extract().response().asString();
		System.out.println(Response);
	}
}