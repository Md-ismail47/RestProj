package pojo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Test;

public class Vt_Class4
{
	@Test
	public  void VTselectnewpaymentmethod() throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ycs\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://raagvitech-ea-dev-ed.my.salesforce.com/_ui/common/apex/debug/ApexCSIPage");
		driver.findElement(By.id("username")).sendKeys("durga@blackthorn.io");
		driver.findElement(By.id("password")).sendKeys("Raagvi@1234567");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(10000);
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_E);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_E);
		Set<String> handles = driver.getWindowHandles();
		Thread.sleep(10000);
		WebElement console = driver.findElement(By.xpath("//*[@class='CodeMirror-cursor']"));
		Actions action = new Actions(driver);
		action.click(console).perform();
		action.sendKeys("hello").perform();
		WebElement executeButton = driver.findElement(By.xpath("(//em//button//span[text()='Execute'])[2]"));
		Thread.sleep(3000);
		action.click(executeButton);
		System.out.println(handles.size());
		
		
		
	}

}
