package com.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.browser.DriverFactory;
import com.qa.browser.DriverManager;
import com.qa.utils.Constants;

public class BasePge {
	 public static Logger log = Logger.getLogger(DriverFactory.class.getClass());
	
	public BasePge(){
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public static void expliciteWait(WebElement element){
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Constants.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Waiting for visibility of "+element);
	}
	
	public static void click(WebElement element){
		element.click();
		log.info("Clicked on the "+element);
	}
	
	public static void sendkeys(WebElement element, String keysToSend){
		element.sendKeys(keysToSend);
		log.info("Entering "+keysToSend+" to "+element);
	}
	
	public static void moveToElement(WebElement element) {
		Actions actions= new Actions(DriverManager.getDriver());
		actions.moveToElement(element).build().perform();
		log.info("Moved to the location of "+element);
	}
	
	
}
