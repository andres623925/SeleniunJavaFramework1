package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class ExcelDataProvider {

	static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();

		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver_79.exe");
		driver = new ChromeDriver();
	}
	
	@Test(dataProvider="test1data")
	public void test1(String userName, String password) throws InterruptedException {
		
		//System.out.println(userName+" | "+password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void tearDownTest() {
		//Close Browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");

		PropertiesFile.setProperties();
		
	}
	
	
	@DataProvider( name = "test1data")
	public static Object[][]  getData() {
		
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath+"\\excel\\data.xlsx";
		String sheeName = "Hoja1";
		
		Object data[][] = testData(excelPath, sheeName);
		
		return data;
	}
	
	
	public static Object[][] testData(String excelPath, String sheeName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheeName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		
		Object data[][] = new Object [rowCount-1][colCount];
		System.out.println(data.length);
		
		for (int i = 1; i < rowCount ; i++) {
			for (int j = 0; j < colCount ; j++) {
				
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data;
	}

}
