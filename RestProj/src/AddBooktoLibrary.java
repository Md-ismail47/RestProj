import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddBooktoLibrary 
{
	@Test(dataProvider = "BookData")
	public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String Response=given().log().all().header("content-Type","application/json").body(Utility.LibraryBody(isbn, aisle)).
		when().post("Library/Addbook.php").then().assertThat().log().all().statusCode(200).extract().response().asString();
		JsonPath js=new JsonPath(Response);
		String Bookid = js.getString("ID");
		System.out.println(Bookid);
	}
	@DataProvider(name="BookData")
	public Object[][] getBookData()
	{
		return new Object[][] {{"SF","008"},{"SF","009"}};
	}
}