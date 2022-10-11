package com.testNGpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampletestNGProgram {
	
	WebDriver driver;

	@BeforeTest

public void launchBrowser() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "D://testngjar//chromedriver_win32//chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get ("https://omayo.blogspot.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		System.out.println("Browser is launched");
		
		Thread.sleep(50000);
	
	
}
	@Test 
	
	public void test(){
		String title = driver.getCurrentUrl();
		
		System.out.println(title);
		
	}
	@AfterTest
	
	public void exitBrowser() {
		
		driver.quit();
	}
}
