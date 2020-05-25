package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendRepotsDemo {

	 private static WebDriver driver = null; 
	
	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		
		//create extentReports and attach report(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	
		// creates a toggle for the given test, adds all log eventes under
		ExtentTest test1 = extent.createTest("Google serache test one", "this is a test to validate google search functionality");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_79.exe");
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Stating Test Case");
		driver.get("https://www.google.com/");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("A B C D");;
		test1.pass("Enter text in searchbox");
		
		// esperamos que el objeto aparesca antes de 10 segundo
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
		test1.pass("Waiting for btnK Element visibility");
		
		
		try {
			driver.findElement(By.name("btnK")).click();
			test1.pass("Pressed keyboard entrer key");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test1.error("Error to Pressed keyboard enter key");
			test1.error(e);
		}
		
		
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		
		test1.info("Test Completed");
		
		
		// creates a toggle for the given test, adds all log eventes under
				ExtentTest test2 = extent.createTest("Google serache test one", "this is a test to validate google search functionality");
				
				System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_79.exe");
				driver = new ChromeDriver();
				
				test2.log(Status.INFO, "Stating Test Case");
				driver.get("https://www.google.com/");
				test2.pass("Navigated to google.com");
				
				driver.findElement(By.name("q")).sendKeys("A B C D");;
				test2.pass("Enter text in searchbox");
				
				
				try {
					driver.findElement(By.name("btnK")).click();
					test2.pass("Pressed keyboard entrer key");
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					test2.error("Error to Pressed keyboard enter key");
					test2.error(e);
				}
				
				
				driver.close();
				driver.quit();
				test2.pass("Closed the browser");
				
				test2.info("Test Completed");
				
		
		extent.flush();
		
	}
	
	
}
