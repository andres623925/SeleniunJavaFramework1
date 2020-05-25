package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.Log4jDemo;

public class GoogleSearchPageObjects {

	private static Logger logger = LogManager.getLogger(GoogleSearchPageObjects.class);
	WebDriver driver = null;
	
	By textbox_search = By.name("q");
	By button_search = By.name("btnK");
	
		
	public GoogleSearchPageObjects (WebDriver driver) {
		this.driver = driver;
	}
	
	public void setTextInsertBox(String text) {
		logger.info(" ---- busca en la pagina el elemento: q y textea: "+ text+" ---- ");
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void waittingVisibility() {
		// esperamos que el objeto aparesca antes de 10 segundo
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_search));
	}
	
	public void clickSearchButton() {
		//luego que aparece ahi si le damos click
		driver.findElement(button_search).click();
	}
	
}
