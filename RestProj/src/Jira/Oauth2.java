package Jira;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;

public class Oauth2
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ycs\\git\\RestAssuredProject\\RestAssuredProject\\RestProj\\Drivers\\chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&service=lso&o2v=2&flowName=GeneralOAuthFlow");
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("ismail.mohammed@raagvitech.com");
		email.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("8749042573@Rtisp");
		password.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		String currenturl = driver.getCurrentUrl();
		String[] splitted = currenturl.split("code");
		String[] code = null;
		System.out.println(splitted[1]);
		code=splitted[1].split("=");
		System.out.println(code[1]);
		String[] coderequired = code[1].split("&");
		String finalcode = coderequired[0];
		System.out.println("final--->"+coderequired[0]);
		driver.close();
		
		String Response = given().urlEncodingEnabled(false).log().all().queryParam("code",finalcode).
		queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
		queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php").
		queryParam("grant_type", "authorization_code").
		when().post("https://www.googleapis.com/oauth2/v4/token").then().log().all().extract().response().asString();
		
		JsonPath js=new JsonPath(Response);
		String accessToken = js.getString("access_token");
		System.out.println(accessToken);
		
		String coursedata = given().when().log().all().queryParam("access_token",accessToken).
		when().post("https://rahulshettyacademy.com/getCourse.php").then().log().all().extract().response().asString();
		System.out.println(coursedata);
		
		
		
		
	}
}