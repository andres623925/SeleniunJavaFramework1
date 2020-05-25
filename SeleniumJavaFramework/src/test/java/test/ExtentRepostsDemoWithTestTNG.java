package test;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.GoogleSearchPageObjects;

public class ExtentRepostsDemoWithTestTNG {

	ExtentHtmlReporter htmlReporter = null;
	ExtentReports extent = null;
	WebDriver driver = null;
	
	@BeforeSuite
	public void setUp() {
	
		htmlReporter = new ExtentHtmlReporter("extentReport.html");
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest() {

        String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_79.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void test1() {
		ExtentTest test = extent.createTest("MyFirstTest Google", "Sample description");
		
		GoogleSearchPageObjects searchPagesObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://www.google.com");
		test.pass("Navigate to google.com");
		
		searchPagesObj.setTextInsertBox("A B C D");
		test.pass("input text in the box");
			
		searchPagesObj.waittingVisibility();
		test.pass("waitting to the button is visibility");
		
		searchPagesObj.clickSearchButton();
		test.pass("Click in the button");
		
		try {
			test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());
			test.addScreenCaptureFromPath("screenshot1.png");
			System.out.println("FINALIZADO SCREEN");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void test2() throws IOException {
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@AfterTest
	public void tearDownTest() {
		
		//Close Browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		
	}
	
	@AfterSuite
	public void testDown() {
		extent.flush();
	}
	
	
}
