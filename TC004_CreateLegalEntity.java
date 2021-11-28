package SelBootCamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_CreateLegalEntity {

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
		
		//Click on New Legal Entity
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(3000);
		
		//Enter Name as 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Salesforce Automation by Sivaraj");
		
		//click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(3000);
		
		//verify Legal Entity Name
		String verifyText = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		System.out.println(verifyText);
		
		
	}

}
