package com.guru99.pageobjectmodel;

import com.driver.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class ScriptExecutor {

	private static final String UID = "mngr260636";
	private static final String PWD = "etYbYrY";
	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getDriver("chrome");
		driver.get("http://demo.guru99.com/V4/");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setTxtUserId(UID);
		loginPage.setTxtPassword(PWD);
		loginPage.clickOnLoginButton();

		HomePage homePage = new HomePage(driver);
		homePage.clickOnNewCustomerLink();
		NewCustomerPage newCustomerPage = new NewCustomerPage(driver);
		newCustomerPage.setTxtCustomerName("Rahul Shah");
		newCustomerPage.setRadioGender("f");

		homePage.clickOnNewAccountLink();
		NewAccountPage newAccountPage = new NewAccountPage(driver);
		newAccountPage.setTxtCustomerId("12345");
	}
}