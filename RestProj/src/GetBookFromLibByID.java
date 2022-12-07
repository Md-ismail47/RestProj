import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetBookFromLibByID
{
	@Test
	public void getBookById()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String Response = given().log().all().queryParam("ID", "SF004").when().get(" Library/GetBook.php").then().log().all().assertThat().extract().response().asString();
		System.out.println(Response);
	}

}
