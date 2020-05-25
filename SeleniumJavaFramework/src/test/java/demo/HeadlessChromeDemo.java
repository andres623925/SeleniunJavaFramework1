package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeadlessChromeDemo {

	public static void main(String[] args) {
		test();	
	}
	
	public static void test() {

		System.setProperty("webdriver.chrome.driver", "C:\\Andres\\WorkSpace\\SeleniumJavaFramework\\drivers\\chromedriver\\chromedriver_81.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1280,800");
		
		WebDriver driver = new ChromeDriver(options);
		
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation");
		
		By button_search = By.name("btnK");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_search));
		
		driver.findElement(button_search).click();
		
		driver.close();
		driver.quit();
		
		System.out.println("Complited");
	}
	
}
