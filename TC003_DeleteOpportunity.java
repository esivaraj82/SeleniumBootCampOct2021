package TestNG;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_DeleteOpportunity {

	@Test 
	public void Delete() throws InterruptedException {
	//public static void main(String[] args) throws InterruptedException {

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

		//click Sales from App Launcher
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);

		//Click on Opportunity tab
		//driver.findElement(By.xpath("//span[text()='Opportunities']")).click();
		WebElement opp = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", opp);
		Thread.sleep(3000);

		//Search the Opportunity
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		search.sendKeys("Salesforce Automation by Sivaraj");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(4000);

		//Click on the Drop down icon and Select Delete
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		WebElement verifyText = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		verifyText.sendKeys("Salesforce Automation by Sivaraj");
		verifyText.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String nomatches = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		System.out.println(nomatches);
		driver.close();
		}


}


