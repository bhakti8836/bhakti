package Selenium2;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//  W3 Schools Website and it's child pop-up windows

public class popups {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/js/js_popup.asp");
		
		WebElement AlertBox = driver.findElement(By.xpath("(//a[text()='Try it Yourself »'])[1]"));
		WebElement ConfirmBox = driver.findElement(By.xpath("(//a[text()='Try it Yourself »'])[2]"));
		WebElement PromptBox = driver.findElement(By.xpath("(//a[text()='Try it Yourself »'])[3]"));
		WebElement LineBreak = driver.findElement(By.xpath("(//a[text()='Try it Yourself »'])[4]"));
		
		AlertBox.click();
		ConfirmBox.click();
		PromptBox.click();
		LineBreak.click();
		
		//String k = driver.getWindowHandle(); // main page address (Hex Value)
		//System.out.println(k);
		
		// main page address + child browser windows address
		Set <String> a =driver.getWindowHandles(); // set for unique web addresses
		
		ArrayList <String> addr=  new ArrayList(a);
		
		String a1 = addr.get(0); // main web page address (Hex value)
		System.out.println(a1);
		
		// web addresses of child windows 
		String a2 = addr.get(1); // alert box!
		System.out.println(a2);
		
		String a3 = addr.get(2); // Confirm Box
		System.out.println(a3);
		
		String a4 = addr.get(3); // Prompt box
		System.out.println(a4);
		
		String a5 = addr.get(4); // Line break
		System.out.println(a5);
		
		driver.switchTo().window(a1); // main web page
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(a2); //  alert box!
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(a3); //  Confirm box
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(a4); //  Prompt box!
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(a5); //  Line Break!
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
	}

}
