package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteOpport extends BaseClass {
	
	@Test 
	public void DeleteOpportunity() throws InterruptedException {
				
		//click Sales from App Launcher
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

				//Click on the Drop down icon and Select Delete
				driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@title='Delete']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
				WebElement verifyText = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
				verifyText.sendKeys("Salesforce Automation by Sivaraj");
				verifyText.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				String nomatches = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
				System.out.println(nomatches);
	}

}
