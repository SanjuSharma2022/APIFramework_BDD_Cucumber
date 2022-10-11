package Project;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class SeleniumAuto {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D://testngjar//chromedriver_win32//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
		
		
		
		System.out.println("Browser is launched");
		
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		Thread.sleep(5000);
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		System.out.println("First Testcase Passed");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		
		Thread.sleep(5000);
		 driver.findElement(By.name("firstName")).sendKeys("Jim");
		 Thread.sleep(2000);
		 driver.findElement(By.name("middleName")).sendKeys("Kr.");
		 Thread.sleep(2000);
		 driver.findElement(By.name("lastName")).sendKeys("Korbett");
		 Thread.sleep(2000);
		 
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")).click();
		//driver.close();
		
		System.out.println("Second Testcase Passed");
		
		driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(4) > div > div:nth-child(1) > div > div:nth-child(2) > input")).sendKeys("Jimbett");
		
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div.oxd-form-row.user-password-row > div > div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell > div > div:nth-child(2) > input")).sendKeys("Xy@12345");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")).sendKeys("Xy@12345");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
		
		Thread.sleep(20000);
		
		
		File f =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Files.copy(f, new File ("C:\\Users\\sanju\\Desktop\\workspace\\Screenshot.jpg"));
	

	}

}
