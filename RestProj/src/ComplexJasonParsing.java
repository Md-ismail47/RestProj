import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ComplexJasonParsing 
{
	public static void main(String[] args)
	{
		JsonPath js = new JsonPath(Utility.dummyResponse());
		//Print the number of courses available.
		 int Coursesize = js.getInt("courses.size()");
		System.out.println("Number of courses availabe is-->"+Coursesize);		
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Total purchase amount is-->"+purchaseAmount);
		String firstCourseTitle = js.getString("courses[0].title");
		System.out.println("The first course title is-->"+firstCourseTitle);
		for(int i=0;i<Coursesize;i++)
		{
			System.out.println("For "+js.getString("courses["+i+"].title")+" price is "+js.getInt("courses["+i+"].price"));
		}
		System.out.println("Number of copies sold by RPA course is "+js.getString("courses[2].copies"));
		int sum=0;
		for(int j=0;j<Coursesize;j++)
		{
			int multi=0;
			int finalcourseprice= js.getInt("courses["+j+"].price");
			int finalCopies= js.getInt("courses["+j+"].copies");
			multi=finalcourseprice*finalCopies;
			sum=sum+multi;	
		}
		System.out.println(sum);
		Assert.assertEquals(sum,purchaseAmount );
	}
}