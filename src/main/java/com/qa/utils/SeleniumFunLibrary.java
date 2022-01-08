package com.qa.utils;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.browser.DriverFactory;
import com.qa.browser.DriverManager;

public class SeleniumFunLibrary  extends DriverFactory{
	
	public static String getRandomtString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
	
	public static void switchtoFrame(int index) throws Exception{
		try {
			DriverManager.getDriver().switchTo().frame(index);
		} catch (Exception e) {
			throw new Exception("Frame with index of"+index+" is not available");
		}
	}
	
	public static void swithtoFrame(String nameorId) throws Exception{
		try {
			DriverManager.getDriver().switchTo().frame(nameorId);
		} catch (Exception e) {
			throw new Exception("Frame with name or Id "+nameorId+" is not available");
		}
	}
	
	public static void acceptAlert() throws Exception{
		try{
			DriverManager.getDriver().switchTo().alert().accept();
		} catch (Exception e){
			throw new Exception("There is no alert present here please check");
		}
	}
	
	public static void dismissAlert() throws Exception{
		try {
			DriverManager.getDriver().switchTo().alert().dismiss();
		} catch (Exception e) {
			throw new Exception("There is no alert present here please check");
		}
	}
	
	public static String getTesxtofAlert() throws Exception{
		String allertText = null;
		try {
			allertText = DriverManager.getDriver().switchTo().alert().getText();
		} catch (Exception e) {
			throw new Exception("Text of allert is not posible to get");
		}
		return allertText;
	}
	
	public static void windowHandles(String nameOrHandle){
		Set<String> windows = DriverManager.getDriver().getWindowHandles();
		for(String tabs : windows){
			DriverManager.getDriver().switchTo().window(tabs);
		}
	}
	
	public static void switchToParentWindow(String parentID) throws Exception{
		try {
			DriverManager.getDriver().switchTo().window(parentID);
		} catch (Exception e) {
			throw new Exception("There is no parent window present");
		}
	}
	
	public static void selectValueFromDropDownByText(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public static void selectValueFromDropDownByIndex(WebElement element, int value)
	{
		Select select = new Select(element);
		select.selectByIndex(value);
	}
	
	public static void selectValueFromDropDownByValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/*public static void  getoptionsofListBox(WebElement element, String [] expectedOptions ){
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < expectedOptions.length; i++) {
		    String optionValue = options.get(i).getAttribute("value");
		}
	}*/
	

}
