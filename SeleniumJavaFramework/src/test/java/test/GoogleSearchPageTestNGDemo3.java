package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.Log4jDemo;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTestNGDemo3 {

	private static Logger logger = LogManager.getLogger(GoogleSearchPageTestNGDemo3.class);
	
	static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		
		logger.info("------ INICIA TEST ---------");
		
		String projectPath = System.getProperty("user.dir");
		logger.info("Settea el projectPath: "+ projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_79.exe");
		logger.info("Settea el google chrome driver: "+projectPath+"\\drivers\\chromedriver\\chromedriver_79.exe");
		
		driver = new ChromeDriver();
		
	}
	
	@Test
	private  void googleSearchTest() {
		
		logger.debug("Crea el pageObject de la pagina");
		GoogleSearchPageObjects searchPagesObj = new GoogleSearchPageObjects(driver);
		
		
		driver.get("https://www.google.com");
		logger.info("va a la pagina: https://www.google.com");
		
		logger.info("Va a introducir la palabra a buscar");
		searchPagesObj.setTextInsertBox("A B C D");
			
		searchPagesObj.waittingVisibility();
		
		searchPagesObj.clickSearchButton();
		
	}
	
	@AfterTest
	public void tearDownTest() {
		
		//Close Browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		
		logger.info("----- Fin de la Ejecucion ------");
	}
	
	
}
