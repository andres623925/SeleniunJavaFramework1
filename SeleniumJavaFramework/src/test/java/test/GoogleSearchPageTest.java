package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {

	static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearchTest();
	}

	private static void googleSearchTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_79.exe");
		driver = new ChromeDriver();
		
		GoogleSearchPageObjects searchPagesObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://www.google.com");
		
		searchPagesObj.setTextInsertBox("A B C D");

		searchPagesObj.clickSearchButton();
		
		driver.close();
		driver.quit();
	}
	
	
}
