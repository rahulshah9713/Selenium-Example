package com.guru99.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage {

	@FindBy(name = "cusid")
	private WebElement txtCustomerId;

	public NewAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setTxtCustomerId(String id){
		this.txtCustomerId.sendKeys(id);
	}
}
