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

public class TC022_CustomerServiceOptions {


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
		//lst.addAll(allWindows);
		driver.switchTo().window(lst.get(1));
		String newWindowTitle = driver.getTitle();
		System.out.println(newWindowTitle);
		Thread.sleep(5000);


		//shadow-Root - only Javascript will work, normal locator will not work for Shadow-root
		//Click on Product Menu
		WebElement productMenu = (WebElement)driver.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > button > span:nth-child(1)\")");
		productMenu.click();
		Thread.sleep(3000);
		//Click on sub Menu- Serivces
		WebElement serviceMenu = (WebElement)driver.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > div > div > div > div:nth-child(1) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span\")");
		serviceMenu.click();
		Thread.sleep(3000);

		//Verify the tabs displayed in the page
		String title = driver.getTitle();
		System.out.println(title);
		
		//WebElement list = (WebElement)driver.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul\")");
		
	}


}
