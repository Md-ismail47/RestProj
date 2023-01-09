package Ecom;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Ecom
{
	//login to application
	public static void main(String[] args)
	{
		PojoCredentails getcreds = new PojoCredentails();
		getcreds.setUserEmail("ismailzabi47@gmail.com");
		getcreds.setUserPassword("Qwerty@123");
		RequestSpecification requestUri = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").setContentType(ContentType.JSON).build();
		LoginResponsePayload resp = given().spec(requestUri).log().all().body(getcreds).when().post("api/ecom/auth/login").then().log().all().extract().response().as(LoginResponsePayload.class);
		String token = resp.getToken();
		String userid = resp.getUserId();
		System.out.println("Token-->"+token);
		System.out.println("userid-->"+userid);
		
		
		//Add Product
		RequestSpecification Addproductspec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addHeader("Authorization", token).build();
		ProductResponse AddproductResponse = given().log().all().spec(Addproductspec).param("productName", "Puma").param("productAddedBy", userid).param("productCategory", "fashion").
		param("productSubCategory", "shoes").param("productPrice", "80000").param("productDescription", "Puma Originals").param("productFor", "Boys").
		multiPart("productImage",new File("C:\\Users\\ycs\\Downloads\\puma.jpg")).when().post("api/ecom/product/add-product").then().log().all().extract().response().as(ProductResponse.class);
		String productid = AddproductResponse.getProductId();
		
		
		//Place order
		
		Orderssubbody orderdetail= new Orderssubbody();
		orderdetail.setCountry("inida");
		orderdetail.setProductOrderedId(productid);
		
		List<Orderssubbody> orderdetaillist=new ArrayList<Orderssubbody>();
		orderdetaillist.add(orderdetail);
		orders orders1=new orders();
		orders1.setOrders(orderdetaillist);
		RequestSpecification CreateOrders = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").setContentType(ContentType.JSON).addHeader("Authorization", token).build();
		given().spec(CreateOrders).log().all().body(orders1).when().post("api/ecom/order/create-order").then().log().all().statusCode(201).extract().response().asString();
		
		//Delete the product
		
		given().log().all().spec(Addproductspec).when().delete("api/ecom/product/delete-product/"+productid).then().log().all().statusCode(200);
		
		
	}
}