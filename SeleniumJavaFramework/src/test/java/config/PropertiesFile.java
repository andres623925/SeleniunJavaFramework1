package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.GoogleSearchPageTestNGDemo;

public class PropertiesFile {

	private static Properties pro = new Properties();
	static String projectPath =  System.getProperty("user.dir");

	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
	}

	public static void getProperties() {

		try {

			InputStream input = new FileInputStream(projectPath+"\\src\\test\\java\\config\\config.properties");
			pro.load(input);
			String browser = pro.getProperty("browser");
			System.out.println(browser);
			GoogleSearchPageTestNGDemo.BrowserName = browser;

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(projectPath+"\\src\\test\\java\\config\\config.properties");
			pro.setProperty("browser","pass");
			pro.store(output, null);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

}
