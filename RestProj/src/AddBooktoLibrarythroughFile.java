import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddBooktoLibrarythroughFile 
{
	@Test()
	public void addBook() throws IOException
	{
		RestAssured.baseURI="http://216.10.245.166";
		String Response=given().log().all().header("content-Type","application/json").body(new String(Files.readAllBytes(Paths.get("C:\\Users\\ycs\\Desktop\\sample.json")))).
		when().post("Library/Addbook.php").then().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(Response);
	}
}