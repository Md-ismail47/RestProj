package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest2 {
	
	

	@Test
	public  void launch()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ycs\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
	
		WebDriver driver= new ChromeDriver();
		driver.get("https://facebook.com");
		driver.navigate().to("https://www.google.com");
		driver.navigate().to("https://in.linkedin.com/");
		driver.navigate().to("https://www.google.com");
		driver.navigate().to("https://in.linkedin.com/");
	
	}

}
