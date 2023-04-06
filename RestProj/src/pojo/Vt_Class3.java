package pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Vt_Class3
{
	@Test
	public  void VTselectnewpaymentmethod() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ycs\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://raagvitech-ea-dev-ed.lightning.force.com/lightning/r/Opportunity/0065j00000Nch2CAAR/view");
		driver.findElement(By.id("username")).sendKeys("durga@blackthorn.io");
		driver.findElement(By.id("password")).sendKeys("Raagvi@1234567");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(50000);
		Select sel2 = new Select(driver.findElement(By.xpath("//select [@name='paymentGatewaySelector']")));
		 Thread.sleep(4000);
		
		sel2.selectByVisibleText("Blackthorn Stripe Test (Stripe)");
		 Thread.sleep(4000);
		 WebElement ele2 =driver.findElement(By.xpath("//span[@id='relatedToParent']//label[@for='lookup-348']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].scrollIntoView();", ele2);
		 Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@placeholder='Payment Method']")).sendKeys("BT Dispute Card");
		WebDriverWait wait= new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='BT Dispute Card']")));
		
		  System.out.println("3");
			 WebElement e =driver.findElement(By.xpath("//h5[text()='BT Dispute Card']"));
			 Actions act = new Actions(driver);
     act.moveToElement(e).click().perform();
		
		 Thread.sleep(4000);	
		
		 System.out.println("4");
		driver.findElement(By.xpath("//input[@placeholder='Amount']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys("2");
		Thread.sleep(4000);
		WebElement de =driver.findElement(By.xpath("//label[normalize-space()='Description']"));
		 jse.executeScript("arguments[0].scrollIntoView();", de);
		WebElement e1 =driver.findElement(By.xpath("//button[text()='Process']"));
    
		 jse.executeScript("arguments[0].click();", e1);
		
	}

}
