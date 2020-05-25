package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1_GoogleSearch {
	
	public static void main(String[] args) {
		
		Test1_GoogleSearch ts1 = new Test1_GoogleSearch();
		ts1.googleSearch();
	}

	
	public void googleSearch() {
	
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		
		System.out.println("prueba0------");
		
		WebDriver driver = new ChromeDriver();
		System.out.println("prueba1------");
		
		
		
		driver.get("https://www.google.com");
		//driver.findElement(By.name("q")).sendKeys("Automatization Step by Step");
		
		//driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnI']")).click();
		//driver.close();
		
		System.out.println("Test Completed Succesfully");
	}
}
