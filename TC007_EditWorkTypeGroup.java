package SelBootCamp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_EditWorkTypeGroup {

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

		
		//click Work Type Group from App Launcher
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//p[text()='Work Type Groups']")));
		Thread.sleep(5000);
		
		//Search the Work Type Group 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Salesforce Automation by Sivaraj"+Keys.ENTER);
		Thread.sleep(4000);

		//Click on the Dropdown icon and Select Edit
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(3000);

		//Enter Description as 'Automation'.
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).clear();
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys("Automation");

		//Select Group Type as 'Capacity'
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[text()='Default']")));
		driver.findElement(By.className("select")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Capacity']")).click();

		//Click on Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(4000);
		
		//Click on 'Salesforce Automation by Your Name'and Verify Description as 'Automation'
		driver.findElement(By.xpath("(//a[@data-aura-class='forceOutputLookup'])[1]")).click();
		Thread.sleep(3000);
		String verifyDescription = driver.findElement(By.xpath("//span[@data-aura-class='uiOutputTextArea']")).getText();
		System.out.println(verifyDescription);
		driver.close();
	}


}


