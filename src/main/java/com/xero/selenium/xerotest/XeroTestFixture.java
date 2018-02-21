package com.xero.selenium.xerotest;

import java.util.concurrent.TimeUnit;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * author Anandhi
 *
 */
@RunWith(ConcordionRunner.class)
public class XeroTestFixture
{
    private WebDriver driver;
	
	public void openUrl(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\karuppah\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	public void login(String username,String password) {
		driver.findElement(By.xpath("//a[@href='https://login.xero.com/']")).click();
		
		
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys(username);
		
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("submitButton")).click();
		
	}
	
	public void openBankAccounts() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("Accounts")));
		driver.findElement(By.id("Accounts")).click();
		driver.findElement(By.linkText("Bank Accounts")).click();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addBankAccount() {
	   new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a#ext-gen16")));
	   driver.findElement(By.cssSelector("a#ext-gen16")).click();
	   
	   Wait wait = new FluentWait(driver)
			   .withTimeout(60, TimeUnit.SECONDS)
			   .pollingEvery(5, TimeUnit.SECONDS)
			   .ignoring(StaleElementReferenceException.class,IndexOutOfBoundsException.class);
	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-automationid='popularBanksList']")));
	   WebElement banks= driver.findElement(By.cssSelector("div[data-automationid='popularBanksList']"));
	   banks.findElement(By.tagName("li")).click();
	   
	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='e.g Business Account']")));
	   driver.findElement(By.cssSelector("input[placeholder='e.g Business Account']")).click();
	   driver.findElement(By.cssSelector("input[placeholder='e.g Business Account']")).sendKeys("TEST ACCOUNT");
	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Please select one']")));
	   driver.findElement(By.cssSelector("input[placeholder='Please select one']")).click();
	   driver.findElement(By.className("ba-combo-list-item")).click();
	
	   
	   
	  
	}
	
}

