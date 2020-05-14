package com.guru99.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "uid")
	private WebElement txtUserId;

	@FindBy(name = "password")
	private WebElement txtPassword;

	@FindBy(name = "btnLogin")
	private WebElement btnLogin;

	@FindBy(name = "btnReset")
	private WebElement btnReset;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setTxtUserId(String userId){
		this.txtUserId.sendKeys(userId);
	}

	public void setTxtPassword(String password){
		this.txtPassword.sendKeys(password);
	}

	public void clickOnLoginButton(){
		this.btnLogin.click();
	}

	public void clickOnResetButton(){
		this.btnReset.click();
	}

}
