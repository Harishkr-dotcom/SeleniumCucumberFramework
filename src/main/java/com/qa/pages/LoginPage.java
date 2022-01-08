package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.browser.DriverManager;

import StepDefinations.HomePageSteps;

public class LoginPage extends BasePge  {
	@FindBy(xpath="//a[normalize-space()='Sign in']")
	public WebElement Signin;
	
	@FindBy(xpath="//label[normalize-space()='Username or email address1']")
	public WebElement emailText;
	
	@FindBy(xpath="//label[normalize-space()='Password']")
	public WebElement passwordText;
	
	@FindBy(xpath="//input[@id='login_field']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@name='commit']")
	public WebElement login;
	
	public LoginPage(){
		super();
	}
	
	public void clickOnSignIn(){
		click(Signin);
	}
	
	public String verifyURL(){
		return DriverManager.getDriver().getCurrentUrl();
	}
	
	public boolean isEmailDisplayed(){
		return emailText.isDisplayed();
	}
	
	public boolean isPasswordDisplayed(){
		return passwordText.isDisplayed();
	}
	
	public HomePage doLogin(String UserName , String Password){
		sendkeys(userName, UserName);
		sendkeys(password, Password);
		click(login);
		return new HomePage();
	}

}
