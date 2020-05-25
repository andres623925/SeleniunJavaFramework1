package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWebDemo {

	public static void main(String[] args) {
		
		seleniumWaits();
		
	}
	
	public static void seleniumWaits() {
	
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",  projectPath+"\\drivers\\chromedriver\\chromedriver_79.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//default frencuency is 250 ms
		
		driver.get("Https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation Step By Stpeb");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.findElement(By.name("A B C D"));
		
		driver.close();
		driver.quit();
		
		
	}
}
