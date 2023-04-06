package pojo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Paylink {
	@Test
	public  void VTselectnewpaymentmethod() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ycs\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to("https://paylink.blackthorn.io/BQX4DAXDnyvPFS8vybECDSuTZM8e87u3BMorVaElphYIfZrCHR5ekF2NoelNKcSTEubwsJ977OPjGT_tK6xGiw");
		driver.findElement(By.xpath("//span[text()='Pay']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@name='cardnumber']")).sendKeys("4242424242424242");
//		driver.switchTo().parentFrame();
//		Thread.sleep(3000);
//		driver.switchTo().frame(1);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@name='exp-date']")).sendKeys("05/26");
//		driver.switchTo().parentFrame();
//		Thread.sleep(3000);
//		driver.switchTo().frame(2);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("026");
		TakesScreenshot a = ((TakesScreenshot)driver);
		 File scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// paste the screenshot in the desired location  
		FileUtils.copyFile(scrShot, new File("C:\\Users\\ycs\\Desktop\\Screenshots\\Scr.jpg"));
		
	

		}
	

}
