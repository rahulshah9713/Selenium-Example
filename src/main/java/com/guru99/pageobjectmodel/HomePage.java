package com.guru99.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "New Customer")
	private WebElement newCustomerLink;

	@FindBy(linkText = "Edit Customer")
	private WebElement editCustomerLink;

	@FindBy(linkText = "New Account")
	private WebElement newAccountLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewCustomerLink(){
		this.newCustomerLink.click();
	}
	public void clickOnEditCustomerLink(){
		this.editCustomerLink.click();
	}
	public void clickOnNewAccountLink(){
		this.newAccountLink.click();
	}
}
