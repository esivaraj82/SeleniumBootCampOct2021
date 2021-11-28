package SelBootCamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC010_WorkTypeGroupSortName {

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

		//Enter Description as 'Automation'.
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys("Automation");

		//Select Group Type as 'Capacity'
		driver.findElement(By.xpath("//a[@class='select']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Capacity']")).click();
		//)
		//click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(5000);

		//Verify the Alert message (Complete this field) displayed for Work Type Group Name
		String verifyError = driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText();
		System.out.println(verifyError);
		

	}

}
