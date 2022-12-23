package lambda.CrossBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testt {

	WebDriver driver;

	@Test
	@Parameters("Browser")
	public void BrowserLaunch(String Browser) throws InterruptedException {

		if (Browser.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (Browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement fs = driver.findElement(By.xpath("//a[text()=\"Sign up for Free\"]"));
		fs.click();
		Thread.sleep(2000);

		WebElement fullName = driver.findElement(By.xpath("//input[@placeholder=\"Full Name*\"]"));
		fullName.sendKeys("Bhakti Raskar");
		Thread.sleep(2000);

		WebElement mail = driver.findElement(By.id("email"));
		mail.sendKeys("bhaktiraskar8836@gmail.com");

		Thread.sleep(2000);

		WebElement pass = driver.findElement(By.id("userpassword"));
		pass.sendKeys("bhaktiR@33");
		Thread.sleep(2000);

		WebElement mob = driver.findElement(By.id("phone"));
		mob.sendKeys("9322203900");
		Thread.sleep(2000);
		
		WebElement signup = driver.findElement(By.xpath("//button[@data-amplitude=\"R_signup\"]"));
		signup.click();
		Thread.sleep(2000);
		
		WebElement term = driver.findElement(By.xpath("//samp[@style=\"margin-right: 5px;\"]"));
		term.click();
		Thread.sleep(20000);

		WebElement signIn=driver.findElement(By.xpath("//button[text()=\"FREE SIGN UP\"]"));
		signIn.click();
	
		Thread.sleep(20000);

		driver.quit();
	}

}
