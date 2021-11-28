package SelBootCamp;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC019_ContentAddProductNewCase {


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

		//Give SRM Steels in Search Box and search
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("SRM Steels"+Keys.ENTER);
		Thread.sleep(10000);

		//Click on the SRM Steels under Opportunity Name
		driver.findElement(By.xpath("//a[@title='SRM  Steels']")).click();
		Thread.sleep(5000);
		
		//Click on  New case, click inside the contact name and select the first contact
		driver.findElement(By.xpath("//button[text()='New Case']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		driver.findElement(By.xpath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']")).click();
		Thread.sleep(5000);
		
		//Select Status as New and give subject  as New Case  to SRM Steels
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("New Cases to SRM Steels");
		Thread.sleep(3000);
	
		//Click on Save
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		
		driver.close();
	}
}

/*1. Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All
4. Click on Content tab 
5. Click View All Key Deals in Key Deals 
6. Click the dropdown from Opportunities and select All Opportunities
7. Give SRM Steels in Search Box and search
8. Click on the SRM Steels under Opportunity Name
9. Click on  dropdown of Products under Related and select Add Products
10. Click on List Price to sort the result and select the highest priced product
11. Click Next and give product Quantity as 560, click Save
12. Verrify the Sales Price and Product Name
 */