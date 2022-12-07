package restPackage;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class BasicPojo
{
	public static void main(String[] args) {
		
		PojoDemo pj=new PojoDemo();
		pj.setAisle("sf");
		pj.setAuthor("Rahul");
		pj.setIsbn("123");
		pj.setAisle("RestAssured");
		RestAssured.baseURI="http://216.10.245.166";
		String Response=given().log().all().header("content-Type","application/json").body(pj.toString()).
		when().post("Library/Addbook.php").then().assertThat().log().all().statusCode(200).extract().response().asString();
		JsonPath js=new JsonPath(Response);
		String Bookid = js.getString("ID");
		System.out.println(Bookid);
	}
}