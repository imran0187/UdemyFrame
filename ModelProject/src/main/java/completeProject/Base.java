package completeProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Base {

	public static WebDriver driver = null;

	@BeforeTest
	public void baseSetup() throws IOException {

		Properties pro = new Properties();
		FileInputStream file = new FileInputStream(
				"/Users/imranhossan/Documents/workspace/ModelProject/global.Properties");
		pro.load(file);
		System.out.println(pro.getProperty("browser"+" is my browser"));

		if (pro.getProperty("browser").contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/imranhossan/Documents/GeckoDriver/geckodriver");
			driver = new FirefoxDriver();
		} else if (pro.getProperty("browser").contains("chrome")) {
			driver = new ChromeDriver();
		}
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}