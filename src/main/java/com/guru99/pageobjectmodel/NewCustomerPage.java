package com.guru99.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewCustomerPage {

	@FindBy(name = "name")
	private WebElement       txtCustomerName;

	@FindBys(@FindBy(name = "rad1"))
	private List<WebElement> radioGender;

//	@FindBy(name = "name")
//	private WebElement txtCustomerName;
//
//	@FindBy(name = "name")
//	private WebElement txtCustomerName;
//
//	@FindBy(name = "name")
//	private WebElement txtCustomerName;

	public NewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setTxtCustomerName(String name){
		this.txtCustomerName.sendKeys(name);
	}
	public void setRadioGender(String gender){
//		if(gender.equalsIgnoreCase("m")){
//			this.radioGender.get(0).click();
//		}
//		else {
//			this.radioGender.get(1).click();
//		}
		for(WebElement elem: this.radioGender){
			if(gender.equalsIgnoreCase(elem.getAttribute("value"))){
				elem.click();
			}
		}
	}
}
