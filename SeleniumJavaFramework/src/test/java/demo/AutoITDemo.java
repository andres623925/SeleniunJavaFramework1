package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.inject.spi.Element;

public class AutoITDemo {

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Andres\\WorkSpace\\SeleniumJavaFramework\\drivers\\chromedriver\\chromedriver_81.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.tinyupload.com/");
		
		WebElement botton = driver.findElement(By.name("uploaded_file"));
		
		
		Actions actions = new Actions(driver);
		actions.click(botton).perform();
		
	
		System.out.println("inicia script");
		

		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:/Andres/eclipse/TestAutomation/FileUploadScript.exe");
		
		System.out.println("ejecutad script");
		
		Thread.sleep(3000);
		
		//driver.close();
	}
	
}
