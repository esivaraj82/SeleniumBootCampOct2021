package SelBootCamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC014_CreateIndividualWithoutMandatoryFields {

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

		//click Individuals from App Launcher
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//p[text()='Individuals']")));
		Thread.sleep(5000);

		//Click on the Dropdown icon in the Individuals tab
		//driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='Work Type Groups Menu']")));
		driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[contains(text(),'Individuals Menu')]")));
		Thread.sleep(5000);
		
		//Click on New Individual
		driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='New Individual']")));
		Thread.sleep(3000);

		//Enter the Last Name as 'Kumar'
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='--None--']")));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@title='Mr.']")).click();
		
		driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys("Ganesh");

		//click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(5000);

		String lName = driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText();
		System.out.println(lName);
		//driver.close();
	}

}
