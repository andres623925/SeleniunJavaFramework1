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

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	public static void main(String[] args) {
		
		GoogleSearchTest ts1 = new GoogleSearchTest();
		ts1.googleSearch();
	}

	
	public static void googleSearch() {
	
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Andres\\WorkSpace\\SeleniumJavaFramework\\drivers\\chromedriver\\chromedriver_79.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Automatization Step by Step");
		
		GoogleSearchPage.button_search(driver).click();
		//driver.close();
		
		System.out.println("Test Completed Succesfully");
	}
}
