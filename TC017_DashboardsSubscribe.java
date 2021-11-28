package SelBootCamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC017_DashboardsSubscribe {

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

		//click DashBoard from App Launcher
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//p[text()='Dashboards']")));
		Thread.sleep(5000);

		//Click on the Dashboards tab 
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text()='Dashboards']")));
		Thread.sleep(4000);

		//Search the Dashboard 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Srinivasan"+Keys.ENTER);
		Thread.sleep(5000);

		//Click on the Dropdown icon and Select Subscribe
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//span[text()='Show actions'])[6]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Subscribe']")).click();
		Thread.sleep(4000);

		//Select frequency as 'Daily'
		driver.findElement(By.xpath("//span[text()='Daily']")).click();

		//Click on Save in the Edit Subscription popup window. 
		driver.findElement(By.xpath("//span[text()='Save']")).click();

		//driver.close();

	}

}
