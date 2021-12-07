package SelBootCamp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC023_AdministratorCertifications {



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

		// Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Thread.sleep(5000);

		//MouseHover on Products and Select Service 
		Set<String> allWindows = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(allWindows);
		lst.addAll(allWindows);
		driver.switchTo().window(lst.get(1));
		String newWindowTitle = driver.getTitle();
		System.out.println(newWindowTitle);
		Thread.sleep(5000);

		//shadow-Root - only Javascript will work, normal locator will not work for Shadow-root
		//Mouse hover on resources and select SalesForce Certification 
		WebElement resourceMenu = (WebElement)driver.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > button > span:nth-child(1)\")");
		resourceMenu.click();
		Thread.sleep(3000);

		//Click on SalesForce Administrator
		WebElement saleForceCert = (WebElement)driver.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > div > div > div > div:nth-child(2) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span:nth-child(1)\")");
		saleForceCert.click();
		Thread.sleep(3000);
		
		//Navigate to  Certification-Administrator Overview and Confirm the page Title
		Set<String> win = driver.getWindowHandles();
		List<String> lst1 = new ArrayList<String>(win);
		driver.switchTo().window(lst1.get(2));
		String certWindow = driver.getTitle();
		System.out.println(certWindow);
		Thread.sleep(5000);
		//Click on Salesforce Administrator
		driver.findElement(By.xpath("//div[text()='Salesforce Administrator']")).click();
		Thread.sleep(5000);
		
		//Verify the Certifications available for Administrator
		System.out.println("Administrator credentials Certification Details are below:");
		String administrator = driver.findElement(By.xpath("//a[text()='Administrator']")).getText();
		System.out.println(administrator);
		
		String advAdministrator = driver.findElement(By.xpath("//a[text()='Advanced Administrator']")).getText();
		System.out.println(advAdministrator);
		
		String cpaAdministrator = driver.findElement(By.xpath("//a[text()='CPQ Specialist']")).getText();
		System.out.println(cpaAdministrator);
		
		String markAdministrator = driver.findElement(By.xpath("//a[text()='Marketing Cloud Administrator']")).getText();
		System.out.println(markAdministrator);
		
		String platform = driver.findElement(By.xpath("//a[text()='Platform App Builder']")).getText();
		System.out.println(platform);
		
		//close the browser
		driver.quit();
		
	}


}
