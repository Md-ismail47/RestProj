package pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	@Test
	public  void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ycs\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Hello");
		if(url.equals("https://www.google.com/"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}	
		driver.close();
		
		
	}
	
}