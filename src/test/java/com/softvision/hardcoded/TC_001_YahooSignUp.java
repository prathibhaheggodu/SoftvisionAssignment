package com.softvision.hardcoded;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_001_YahooSignUp {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void yahooSign() {

		driver.get("https://login.yahoo.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath(".//*[@id='createacc']")).click();

		driver.findElement(By.xpath(".//*[@id='usernamereg-firstName']")).sendKeys("prathibha123");
		driver.findElement(By.xpath(".//*[@id='usernamereg-lastName']")).sendKeys("heggodu");
		// Select sell1=new
		// Select(driver.findElement(By.xpath(".//*[@id='usernamereg-yid']")));

		// sell1.selectByIndex(0);

		driver.findElement(By.xpath(".//*[@id='usernamereg-yid']")).sendKeys("prathibha123hegg");
		driver.findElement(By.xpath(".//*[@id='usernamereg-password']")).sendKeys("51prathibha");
		driver.findElement(By.xpath(".//*[@id='usernamereg-phone']")).sendKeys("9980111111");

		Select sell2 = new Select(driver.findElement(By.xpath(".//*[@id='usernamereg-month']")));
		sell2.selectByIndex(2);
		driver.findElement(By.xpath(".//*[@id='usernamereg-day']")).sendKeys("09");

		driver.findElement(By.xpath(".//*[@id='usernamereg-year']")).sendKeys("2004");

		driver.findElement(By.xpath(".//*[@id='reg-submit-button']")).click();

	}
}