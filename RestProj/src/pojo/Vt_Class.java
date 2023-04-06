package pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Vt_Class
{
	@Test
	public  void VTselectnewpaymentmethod() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ycs\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://raagvitech-ea-dev-ed.lightning.force.com/lightning/r/Opportunity/0065j000011m8iAAAQ/view");
		driver.findElement(By.id("username")).sendKeys("durga@blackthorn.io");
		driver.findElement(By.id("password")).sendKeys("Raagvi@1234567");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
//		driver.switchTo().frame(driver.findElement(By.xpath("//span[@id='newPaymentMethodParent']")));
//		WebElement paymentmethodselectbox = driver.findElement(By.name("Action"));
		
		
		
	}

}
