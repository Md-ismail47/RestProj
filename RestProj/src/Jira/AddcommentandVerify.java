package Jira;
import static io.restassured.RestAssured.given;

import java.util.Iterator;

import org.codehaus.groovy.control.messages.Message;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;import groovy.transform.Field;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class AddcommentandVerify
{
	@Test
	public void AddCommentandVerify()
	{
		RestAssured.baseURI="http://localhost:8080";
		String message="";
		SessionFilter session = new SessionFilter();
		String Comment="New comment added from eclipse";
		given().log().all().header("Content-Type","application/json").body("{ \"username\": \"ismailzabi47\", \"password\": \"8749042573@Ji\"}").filter(session).when().post("rest/auth/1/session").
		then().log().all().assertThat().extract().response().asString();
		String Response = given().pathParam("Key", "TES-5").log().all().header("Content-Type","application/json").body(JiraBody.AddingComment(Comment)).filter(session).
		when().post("/rest/api/2/issue/{Key}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js=new JsonPath(Response);
		String commentid = js.getString("id");
		System.out.println(commentid);
		
		String issueDetailsRespone = given().pathParam("key", "TES-5").queryParam("fields","comment").filter(session).log().all().when().get("/rest/api/2/issue/{key}").then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js1=new JsonPath(issueDetailsRespone);
		int commentsize = js1.getInt("fields.comment.comments.size()");
		System.out.println(commentsize);
		for(int i=0;i<commentsize;i++)
		{
			String commentsid = js1.getString("fields.comment.comments.id["+i+"]");
			System.out.println(commentsid);
			if(commentsid.equals(commentid))
			{
				message = js1.getString("fields.comment.comments.body["+i+"]");
				Assert.assertEquals(message, Comment);
			}
		}
		
	}
	
}