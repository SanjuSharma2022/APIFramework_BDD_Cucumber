package TESTNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testng2 {
	WebDriver driver;
	@BeforeSuite(groups= {"Regression"})
	public void open() {
		System.out.println("testng second class");
	}
	@AfterSuite(groups= {"Regression"})
	public void close () {
		System.out.println("testng ran success");
	}
	@BeforeClass(groups= {"Regression"})
	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "D://testngjar//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		}
	@AfterClass(groups= {"Regression"})
	public void quit() {
		driver.quit();
	}
	
	@Test(priority = 3,groups = {"Regression"})
	public void URL() {
		driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
	}
}
