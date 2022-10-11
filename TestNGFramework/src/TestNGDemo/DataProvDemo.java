package TestNGDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProvDemo {
	
	WebDriver driver;
	@BeforeMethod()
	public void browse() {
		System.setProperty("webdriver.chrome.driver", "D://testngjar//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@Test(priority= 1)
	public void scroll() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getTitle());
	}
	
	@Test(priority= 2, dataProvider = "logincreds")
	public void login(String usrnm, String passwd) {
		driver.findElement(By.name("username")).sendKeys(usrnm);
		driver.findElement(By.name("password")).sendKeys(passwd);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}
	
	@AfterMethod()
	public void teardown() {
		
		driver.quit();
		System.out.println("last object should fail");
		
	}
	@DataProvider()
	public static Object [][] logincreds (){
		return new Object [][] {{"Admin","admin123"},{123,"4567"}};
	}
}
