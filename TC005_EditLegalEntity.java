package SelBootCamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_EditLegalEntity {

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
		Thread.sleep(3000);
		
		//Click on toggle menu button 
		driver.executeScript("arguments[0].click()", driver.findElement(By.className("slds-r5")));
		Thread.sleep(5000);

		//Click view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);

		//click Legal Entity from App Launcher
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//p[text()='Legal Entities']")));
		Thread.sleep(5000);
		
		//Search the Legal Entity 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Salesforce Automation by Anu"+Keys.ENTER);
		Thread.sleep(3000);
		
		//Click on the Dropdown icon and Select Edit
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(3000);
		
		//Enter the Company name as 'Testleaf'
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("TestLeaf");
		
		//Enter Description as 'SalesForce'.
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).clear();
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys("SalesForce");
		
		//Select Status as 'Active'
		driver.findElement(By.xpath("//a[text()='Active']")).click();
		
		//Click on Save and Verify Status as Active
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(@class,'slds-truncate outputLookupLink')]")).click();
		Thread.sleep(3000);
		String status = driver.findElement(By.xpath("//span[text()='Active']")).getText();
		System.out.println(status);
		driver.close();
	}

}
