package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditOpport extends BaseClass {
	
	@Test 
	public void EditOpportunity() throws InterruptedException {
		
		//Click on Sales
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);

		//Click on Opportunity tab
		//driver.findElement(By.xpath("//span[text()='Opportunities']")).click();
		WebElement opp = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", opp);
		Thread.sleep(3000);

		//Search the Opportunity
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		search.sendKeys("Salesforce Automation by Sivaraj");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(4000);

		//Click the edit button
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(3000);

		//Choose close date as Tomorrow date
		driver.findElement(By.xpath("//input[@name='CloseDate']")).clear();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("11/14/2021");

		//Select 'Stage' as Perception Analysis
		WebElement dropDown=driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[4]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", dropDown);
		//Another way for Java Executor 
		//driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[4]")));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		
		//Select Deliver Status as In Progress
		WebElement delivery = driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following::input"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", delivery);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@title='In progress']")).click();

		//Enter Description as SalesForce
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SalesForce");

		//Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(4000);
		//Verify Stage as Perception Analysis
		String perception = driver.findElement(By.xpath("//span[text()='Perception Analysis']")).getText();
		System.out.println(perception);
	}

}
