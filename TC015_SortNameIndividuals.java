package SelBootCamp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC015_SortNameIndividuals {

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


		//click Individuals from App Launcher 
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//p[text()='Individuals']")));
		Thread.sleep(5000);

		//Click on the Individuals tab 
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text()='Individuals']")));
		Thread.sleep(4000);

		//Click the sort arrow in the Name
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text()='Name']")));
		Thread.sleep(10000);

		//Verify the Individuals displayed in ascending order by Name.
		int size = driver.findElements(By.xpath("//tbody/tr")).size();
		System.out.println(size);
		List<String> names = new ArrayList<String>();
		int i=1;
		do {
			try {
				driver.findElement(By.xpath("//tbody/tr["+i+"]//th/span//a")).sendKeys(Keys.PAGE_DOWN);
				System.out.println(driver.findElement(By.xpath("//tbody/tr["+i+"]//th/span//a")).getText());
			} catch(org.openqa.selenium.NoSuchElementException e) 
			{
				break;
			}
			i=i+1;

		} while (true);
		System.out.println("Completed");
	}
}


