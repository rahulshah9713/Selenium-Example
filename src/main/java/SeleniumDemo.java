import com.driver.factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class SeleniumDemo {
	public static void main(String[] args) throws IOException {
		WebDriver driver = DriverFactory.getDriver("chrome");

		driver.get("http://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium hq");
		searchBox.submit();

		WebElement link = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a"));
		link.click();

		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\rahul.shah\\Desktop\\selenium.jpg"));


//		driver.quit(); # This will close the browser
	}
}