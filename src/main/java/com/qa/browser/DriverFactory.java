package com.qa.browser;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.qa.utils.ReadProperty;

public class DriverFactory {
	
	public static Logger log = Logger.getLogger(DriverFactory.class.getClass());
	
	public  WebDriver  setupDriver(String Browser){
		if(Browser.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeProperties();
			log.info("Browser set to chrome");
		}else if(Browser.equalsIgnoreCase("FireFox")){
			WebDriverManager.firefoxdriver().setup();
			FireFoxOptions();
			log.info("Browser set to ff");
		}else{
			try {
				throw new Exception("Please set up the correct browser in Config.properties");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(ReadProperty.getProperty("WaitTime")), TimeUnit.SECONDS);
		DriverManager.getDriver().manage().deleteAllCookies();
		return DriverManager.getDriver();
	}
	
	protected  void ChromeProperties(){
		ChromeOptions options = new ChromeOptions();
		if(ReadProperty.getProperty("Headless").equalsIgnoreCase("yes")){
			options.addArguments("--headless");
		}else if(ReadProperty.getProperty("Incognito").equalsIgnoreCase("yes")){
			options.addArguments("--incognito");
		}else if(ReadProperty.getProperty("Notification").equalsIgnoreCase("yes")){
			options.addArguments("--disable-notifications");
		}else{
			options.addArguments("--disable-infobars");
			DriverManager.setWebDriver(new ChromeDriver(options));
		}
	}
	
	protected  void FireFoxOptions(){
		FirefoxOptions foptions = new FirefoxOptions();
		if(ReadProperty.getProperty("Headless").equalsIgnoreCase("yes")){
			foptions.setHeadless(true);
		}else if(ReadProperty.getProperty("Incognito").equalsIgnoreCase("yes")){
			foptions.addArguments("-private");
		}else if(ReadProperty.getProperty("Notification").equalsIgnoreCase("yes")){
			foptions.addPreference("dom.webnotifications.enabled", false);
		}else{
			DriverManager.setWebDriver(new FirefoxDriver(foptions));
		}
	}
	
}
