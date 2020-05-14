import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GMAIL {
	private static final String EMAIL = "rahulkshah9713@gmail.com";
	private static final String PASS = "********";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		WebElement signIn = driver.findElement(By.linkText("Sign in"));
		signIn.click();
		WebElement emailText = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		emailText.sendKeys(EMAIL);
		WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]"));
		nextBtn.click();
	}
}
