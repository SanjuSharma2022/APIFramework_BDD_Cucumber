package TESTNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class testng1 {
	WebDriver driver;
	@BeforeSuite(groups= {"Sanity"})
	private void sysout() {
		System.out.println("Testng starts here");

	}
	@AfterSuite(groups= {"Sanity"})
	public void sysout1() {
		System.out.println("Testng ends here");
	}
	@BeforeClass(groups= {"Sanity"})
	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "D://testngjar//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		}
	@Test(priority = 1,groups = {"Sanity"})
	public void launchapp(){
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		System.out.println("Browser opens now");
		
		boolean img = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img")).isDisplayed();
		Assert.assertTrue(img);
		//Thread.sleep(5000);
	}
	@Test(priority = 2,groups = {"Sanity"}) // dependsOnMethods = {"launchapp"},, description = "login for User")
	public void Login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(5000);
		WebElement password = driver.findElement(By.name("password"));
		
		password.sendKeys("admin123");
		Thread.sleep(5000);
		password.submit();
		System.out.println("Hello User , You are logged in now");
		boolean img1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
		Assert.assertTrue(img1);
		}
//	@Test(priority = 3, description = "wrong created to fail next test case")
//	public void user() throws InterruptedException {
//		Thread.sleep(5000);
//		boolean Box = driver.findElement(By.id("tr1")).isDisplayed();
//		AssertJUnit.assertTrue(Box);
//		
//		
//	}
//	@Test(priority = 4, description = "as dependent on user , it will fail too / skip" , dependsOnMethods={"user"})
//	public void title() throws InterruptedException {
//		Thread.sleep(5000);
//		String title = driver.getTitle();
//		System.out.println(title);
		
	@AfterClass(groups= {"Sanity"})
	public void teardown(){
		
		
		driver.quit();
	
}
}
