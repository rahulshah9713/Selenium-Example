package com.guru99.keyworddevelopment.utils;

import com.driver.factory.DriverFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReusableFunction {

	WebDriver driver;

	public String fetchProp(String text) {
		Properties properties = new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\objects.properties");
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(text);
	}

	public void launchAppl() {
		driver = DriverFactory.getDriver("chrome");
		driver.get(fetchProp("URL"));
	}

	public void fillText(String locator, String locatorValue, String parameter) {
		if ("xpath".equals(locator)) {
			driver.findElement(By.xpath(locatorValue)).sendKeys(parameter);
		} else if ("name".equals(locator)) {
			driver.findElement(By.name(locatorValue)).sendKeys(parameter);
		} else if ("id".equals(locator)) {
			driver.findElement(By.id(locatorValue)).sendKeys(parameter);
		}
	}

	public void click(String locator, String locatorValue) {
		if ("name".equals(locator)) {
			driver.findElement(By.name(locatorValue)).click();
		} else if ("id".equals(locator)) {
			driver.findElement(By.id(locatorValue)).click();
		} else if ("xpath".equals(locator)) {
			driver.findElement(By.xpath(locatorValue)).click();
		} else if ("linkText".equals(locator)) {
			driver.findElement(By.linkText(locatorValue)).click();
		}
	}

	public String[][] fetchDataFromExcel() throws IOException {
		String path = fetchProp("KEYWORD_PATH");
		File file = new File(path);
		FileInputStream fs;
		fs = new FileInputStream(file);
		//		String extension = excel_location.substring(excel_location.indexOf('.')+1); //For finding extension of excel

		Workbook wb = null;
		wb = new HSSFWorkbook(fs);     //xls
		//		else {
		//			wb=new XSSFWorkbook(fs);//xlsx
		//		}
		Sheet sheet = wb.getSheet("Sheet1");
		int rows = sheet.getLastRowNum() + 1;
		int cols = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rows][cols];
		for(int i = 0; i < rows; i++) {
			Row row = sheet.getRow(i);
			for(int j = 0; j < cols; j++) {
				Cell cell = row.getCell(j);
				String value = cell.toString();
				data[i][j] = value;
			}
		}
		wb.close();
		return data;
	}
}