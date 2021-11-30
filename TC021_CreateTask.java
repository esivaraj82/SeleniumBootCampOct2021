package SelBootCamp;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC021_CreateTask {


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

			//click Sales from App Launcher
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
			Thread.sleep(10000);
			
			//Click on Global Actions SVG icon
			driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text()='Tasks Menu']")));
			Thread.sleep(9000);
			
			//Click New Task
			//driver.findElement(By.xpath("//span[text()='New Task']")).click();
			driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='New Task']")));
			Thread.sleep(3000);
			
			//Enter subject as "Bootcamp " 
			driver.findElement(By.xpath("(//input[@aria-haspopup='listbox'])[2]")).sendKeys("BootCamp");
			
			//Select Contact from DropDown
			driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@title='High']")).click();

			//Select status as 'Waiting on someone else'
			driver.findElement(By.xpath("//a[@class='select']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@title='Waiting on someone else']")).click();
			Thread.sleep(3000);
			
			//Save and verify the 'Task created' message
			driver.findElement(By.xpath("//span[text()='Save']")).click();
			
	}

}
