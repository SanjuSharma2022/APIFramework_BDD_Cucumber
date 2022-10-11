package TestNGDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMDemo {
	WebDriver driver;
	@BeforeClass
	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "D://testngjar//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		}
	@Test(priority = 1, description = "launch Browser", invocationCount = 2)
	public void launchapp() throws InterruptedException {
		Thread.sleep(5000);
		driver.get ("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		System.out.println("Browser opens now");
		
		boolean img = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img")).isDisplayed();
		Assert.assertTrue(img);
		Thread.sleep(5000);
	}
	@Parameters({"username","password"})
	@Test(priority = 2, description = "login for User") // dependsOnMethods = {"launchapp"},, description = "login for User")
	public void Login(String uname, String pswd) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(uname);
		Thread.sleep(5000);
		WebElement password = driver.findElement(By.name("password"));
		
		password.sendKeys(pswd);
		Thread.sleep(5000);
		password.submit();
		System.out.println("Hello User , You are logged in now");
		boolean img1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
		Assert.assertTrue(img1);
		}
	@Test(priority = 3, description = "wrong created to fail next test case")
	public void user() throws InterruptedException {
		Thread.sleep(5000);
		boolean Box = driver.findElement(By.id("tr1")).isDisplayed();
		Assert.assertTrue(Box);
		
		
	}
	@Test(priority = 4, description = "as dependent on user , it will fail too / skip" , dependsOnMethods={"user"})
	public void title() throws InterruptedException {
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	@Ignore
	@Test (priority = 5)
	public void testcaseE() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
		Thread.sleep(5000);
		boolean O = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[1]/img")).isDisplayed();
		Assert.assertTrue(O);
		
	}
	@AfterClass
	public void teardown(){
		
		
		driver.quit();
	}
}
