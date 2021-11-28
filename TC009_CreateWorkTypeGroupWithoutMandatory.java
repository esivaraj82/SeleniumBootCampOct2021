package SelBootCamp;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC009_CreateWorkTypeGroupWithoutMandatory {

	
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

		//Click the sort arrow in the Work Type Group Name
		driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='Work Type Group Name']")));
		Thread.sleep(3000);
		List<WebElement> sortName = driver.findElements(By.xpath("//tbody/tr/th/span/a"));

		for(WebElement element:sortName ){
			
			System.out.println(element.getText());

		}
		

	}

}
