package SelBootCamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006_CreateWorkTypeGroup {

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

		//click Work Type Group from App Launcher
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//p[text()='Work Type Groups']")));
		Thread.sleep(5000);

		//Click on the Dropdown icon in the Work Type Groups tab
		//driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='Work Type Groups Menu']")));
		driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("(//span[contains(text(),'Work Type Groups')])[3]")));
		Thread.sleep(5000);
		
		//Click on New Work Type Group
		driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='New Work Type Group']")));
		Thread.sleep(3000);

		/*
		//Click on New Legal Entity
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(3000);*/

		//Enter Work Type Group Name as 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Salesforce Automation by Sivaraj");

		//click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(5000);

		//verify Work Type Group Name
		String verifyText = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[2]")).getText();
		System.out.println(verifyText); 

		driver.close();

	}

}
