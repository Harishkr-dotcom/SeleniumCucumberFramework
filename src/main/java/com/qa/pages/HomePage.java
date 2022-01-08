package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage extends BasePge {
	@FindBy(xpath="//summary[@aria-label='View profile and more']")
	public WebElement profilePage;
	
	@FindBy(xpath="(//details-menu[@class='dropdown-menu dropdown-menu-sw'])[2]//a[@class='dropdown-item']")
	List<WebElement> dropdownOptions;
	
	
	public HomePage(){
		super();
	}
	
	public void clickProfile(){
		click(profilePage);
	}
	
	public List<String> getTextOfDropdown(){
		List<String> list = new ArrayList<String>();
		for(WebElement ele: dropdownOptions){
			list.add(ele.getText().trim());
		}
		return list;
	}
	
	
	

}
