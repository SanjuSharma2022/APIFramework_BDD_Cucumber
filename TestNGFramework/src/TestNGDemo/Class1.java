package TestNGDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class1 {
	WebDriver driver;
	@BeforeMethod()
	public void bmethod() {
		System.out.println("Class1 Starts");
	}
	
	@Test(priority = 1)
	public void browse1() {
		System.setProperty("webdriver.chrome.driver", "D://testngjar//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("The testcase : "+Thread.currentThread().getId());
	}
	@AfterMethod()
	public void after() {
		System.out.println("class1 ends");
	}
}
