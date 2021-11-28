package SelBootCamp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC012_EditIndividuals {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		//Launch the SalesForce URL
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Enter the user name
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");

		//Enter the Password
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");

		//Click on Login button
		driver.findElement(By.id("Login")).click();
		Thread.sleep(6000);

		//Click on toggle menu button 
		driver.findElement(By.className("slds-r5")).click();
		Thread.sleep(5000);

		//Click view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);

		
		//click Individuals from App Launcher 
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//p[text()='Individuals']")));
		Thread.sleep(5000);
		
		//Click on the Individuals tab 
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text()='Individuals']")));
		Thread.sleep(4000);
		
		//Search the Individuals 'Kumar' & Click on the Dropdown icon and Select Edit
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Kumar"+Keys.ENTER);
		Thread.sleep(4000);

		//Click on the Dropdown icon and Select Edit
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(3000);

		//Enter the first name as 'Ganesh'.
		driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).clear();
		driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys("Ganesh");

		//Click on Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(4000);
		
		//Verify the first name as 'Ganesh'
		String fName = driver.findElement(By.xpath("(//a[contains(@class,'slds-truncate outputLookupLink')])[1]")).getText();
		System.out.println(fName);
		
		//driver.close();
	}


}


