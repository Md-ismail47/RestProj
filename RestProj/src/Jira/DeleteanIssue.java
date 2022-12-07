package Jira;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import groovy.grape.GrapeIvy;
import io.restassured.RestAssured;

public class DeleteanIssue 
{
	@Test
	public void CreateIssue()
	{
		
		String Sessionid=GetSession.GetSesssion();
		System.out.println(Sessionid);
		RestAssured.baseURI="http://localhost:8080";
		String Response = given().log().all().header("cookie","JSESSIONID="+Sessionid+"").header("Content-Type","application/json").
		when().delete("rest/api/2/issue/TES-4").then().log().all().assertThat().statusCode(204).extract().response().asString();
		
		
	}

}
