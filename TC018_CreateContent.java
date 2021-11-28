package SelBootCamp;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC018_CreateContent {


	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		//Launch the SalesForce URL
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Enter the user name
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");

		//Enter the Password
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");

		//Click on Login button
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);

		//Click on toggle menu button 
		driver.findElement(By.className("slds-r5")).click();
		Thread.sleep(5000);

		//Click view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);

		//Click on Content tab 
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		Thread.sleep(5000);

		//Click View All Key Deals in Key Deals 
		driver.findElement(By.xpath("//span[text()='View All Key Deals']")).click();
		Thread.sleep(10000);
		
		//Click the dropdown from Opportunities and select All Opportunities
		driver.findElement(By.xpath("//button[@title='Select List View']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[text()='My Opportunities']")).click();
		Thread.sleep(5000);
		
		//Click on New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(10000);
		
		//Give Opportunity Name as SRM Steels
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("SRM Steels");
		
		//Select Type as New Customer
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//label[text()='Type']/following::input")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		//Lead Source as Partner Referral
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//label[text()='Lead Source']/following::input")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		
		//Give Amount as 75000 and Select Close Date as Next month 20th day 
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("75000");
		//Select Close Date as Next month 20th day 
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("11/21/2021");
		//Select Stage as Needs Analysis
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//label[text()='Stage']/following::input")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		Thread.sleep(3000);
		
		//Click in Primary Campaign  Source and Select first option
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//label[text()='Primary Campaign Source']/following::input")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Bootcamp']")).click();
		
		//Click Save and Verify the SRM Steels opportunity is created
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(10000);
		String opport = driver.findElement(By.xpath("//slot[@slot='primaryField']/lightning-formatted-text")).getText();
		System.out.println(opport);
		driver.close();
	}
	
	

}
