package TestNGDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class2 {
	WebDriver driver;
	@BeforeMethod()
	public void before() {
		System.out.println("Class2 starts");
	}
	@Test(priority = 2)
	public void browse2() {
		System.setProperty("webdriver.chrome.driver", "D://testngjar//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.get("http://omayo.blogspot.com/");
		System.out.println("The testcase : "+Thread.currentThread().getId());
	}
	@AfterMethod()
	public void aftermethod() {
		System.out.println("Class2 ends");
	}

}
