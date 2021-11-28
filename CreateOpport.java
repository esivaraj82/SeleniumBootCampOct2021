package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateOpport extends BaseClass {
	
	@Test
	public  void CreateNewOpportunity() throws InterruptedException {
		
		//Click on Sales
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);

		//Click on Opportunity tab
		//driver.findElement(By.xpath("//span[text()='Opportunities']")).click();
		WebElement opp = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", opp);
		Thread.sleep(2000);

		//Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(4000);

		//Enter Opportunity name
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input")).sendKeys("Salesforce Automation by Sivaraj");
		//String expectedText = "Salesforce Automation by Sivaraj";

		//Enter Close Date
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("11/13/2021");

		//choose the Stage' as Need Analysis
		WebElement dropDown=driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[3]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", dropDown);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();


		//Click on Save button
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		//New Opportunity should be created with name as  'Salesforce Automation by Your Name'
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']//following::a")).getText();
		System.out.println(text);		
		
		
	}

}
