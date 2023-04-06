package pojo;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Vt_Class5
{
	@Test
	public  void VTselectnewpaymentmethod() throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ycs\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://pay-ncc-1701-dev-ed.develop.lightning.force.com/lightning/o/bt_stripe__Subscription2__c/list?filterName=00BDn00000H1RJZMA3");
		driver.findElement(By.id("username")).sendKeys("ismail@blackthorn.io");
		driver.findElement(By.id("password")).sendKeys("Payments1");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(50000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		System.out.println("hello");
		
	}

}
