package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTestNGDemo {

	static WebDriver driver = null;
	public static String BrowserName = null;
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_79.exe");
			driver = new ChromeDriver();
			
		}else if(BrowserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
		    driver = new FirefoxDriver();
			
		}
		
	}
	
	@Test
	private  void googleSearchTest() {
		
		GoogleSearchPageObjects searchPagesObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://www.google.com");
		
		searchPagesObj.setTextInsertBox("A B C D");

		searchPagesObj.waittingVisibility();
		
		searchPagesObj.clickSearchButton();
		
		driver.close();
		driver.quit();
	}
	
	@AfterTest
	public void tearDownTest() {
		//Close Browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");

		PropertiesFile.setProperties();
		
	}
	
	
}
