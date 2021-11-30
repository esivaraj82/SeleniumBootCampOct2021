package SelBootCamp;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC020_UploadFileSales {


	public static void main(String[] args) throws InterruptedException, AWTException {
		
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
		Thread.sleep(5000);
		
		//Click on Campaigns tab
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Campaigns']")));
		Thread.sleep(5000);
		
		//Click Bootcamp link
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
		Thread.sleep(5000);
		
		//Click on Upload button
		driver.findElement(By.xpath("//div[@title='Upload Files']")).click();
		Thread.sleep(10000);
		
		StringSelection ss = new StringSelection("C:\\Users\\SIVARAJELANGOVAN\\Desktop\\Selenium Bootcamp\\Questions.txt"); 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
			
		Robot robot = new Robot(); 
		
		// Enter to confirm it is uploaded 
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);	
		robot.keyPress(KeyEvent.VK_V); 

		robot.keyRelease(KeyEvent.VK_V); 
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(2000);
		Thread.sleep(5000);
		
		//robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
		
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Thread.sleep(5000);
		
		String verifyLink = driver.findElement(By.xpath("(//span[text()='Questions'])[2]")).getText();
		System.out.println(verifyLink);
	}

}
