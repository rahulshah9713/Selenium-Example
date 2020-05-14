package com.demo.guru99;

import com.driver.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99LoginDemo {

	private static final String UID = "mngr260636";
	private static final String PWD = "etYbYrY";

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getDriver("chrome");
		driver.get("http://demo.guru99.com/V4/");

		if (driver.getTitle().equals("Guru99 Bank Home Page")) {
//			Test case-1: Invalid Case
//			driver.findElement(By.name("uid")).sendKeys("UID");
//			driver.findElement(By.name("password")).sendKeys("PWD");
//			driver.findElement(By.name("btnLogin")).click();
//			Alert alert = driver.switchTo().alert();
//			if (alert.getText().equals("User or Password is not valid")) {
//				alert.accept();
//			}
//			Test case-2: Valid Case
			driver.findElement(By.name("uid")).sendKeys(UID);
			driver.findElement(By.name("password")).sendKeys(PWD);
			driver.findElement(By.name("btnLogin")).click();
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
//				Test case-3: Customer Page Link
				System.out.println("Manager Home Page");
				driver.findElement(By.linkText("New Customer")).click();
				if(driver.getTitle().equals("Guru99 Bank New Customer Entry Page"))
				{
//					Test case-4: New Customer Form
					System.out.println("New Customer Page");
					driver.findElement(By.name("name")).sendKeys("Rahul Shah");
					driver.findElements(By.name("rad1")).get(0).click(); //0 for male, 1 for female
					driver.findElement(By.id("dob")).sendKeys("14121998"); //ddmmyyyy
				}
			}
		}
		else {
			System.out.println("Not a valid URL");
		}
	}
}