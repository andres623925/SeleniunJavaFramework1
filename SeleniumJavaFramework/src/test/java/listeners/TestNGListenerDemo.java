package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGListenerDemo {

	@Test
	public void test1() {
		System.out.println("I am inseide Test 1");
	}
	
	@Test
	public void test2() throws InterruptedException {
		System.out.println("I am inseide Test 2");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		
		System.setProperty("webdriver.chrome.driver",  projectPath+"\\drivers\\chromedriver\\chromedriver_79.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("A B C D");
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("A B C D");
	
		Thread.sleep(2000);
		
		driver.close();
	}

	@Test
	public void test3() {
		System.out.println("I am inseide Test 3");
		throw new SkipException("this test is skipped");
	}

}
