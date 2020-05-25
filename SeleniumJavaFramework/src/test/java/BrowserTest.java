import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		
		/*System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		*/
		System.setProperty("webdriver.chrome.driver",  projectPath+"\\drivers\\chromedriver\\chromedriver_79.exe");
		WebDriver driver = new ChromeDriver();
		
//		System.setProperty("webdriver.ie.driver", projectPath+"\\drivers\\IEDriverServer\\IEDriverServer.exe");
//		WebDriver driver3 = new InternetExplorerDriver();
		
		driver.get("https://www.google.com");
		WebElement textBox = driver.findElement(By.xpath("//input[@name='q']"));
		
		textBox.sendKeys("Automation step by step");
		
		driver.findElement(By.name("btnI")).click();
		
		
		//driver3.close();
	}
}
